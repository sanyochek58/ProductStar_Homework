import java.util.Map;

public class StudentCommandHandler {

    private StudentStorage studentStorage = new StudentStorage();

    public void processCommand(Command command){
        Action action = command.getAction();
        try {
            switch (action) {
                case CREATE -> {
                    processCreateCommand(command);
                    break;
                }
                case UPDATE -> {
                    processUpdateCommand(command);
                    break;
                }
                case DELETE -> {
                    processDeleteCommand(command);
                    break;
                }
                case STATISTICS_BY_COURSES -> {
                    processStatsByCourseCommand(command);
                    break;
                }
                case SEARCH -> {
                    processSearchCommand(command);
                    break;
                }
                case STATISTICS_BY_CITY -> {
                    processStatsByCityCommand(command);
                    break;
                }
                default -> {
                    System.out.println("Действие " + action + " не поддерживается !");
                }
            }
        } catch (Exception e) {
            System.out.println("Не удалось обработать введённые данные: " + e.getMessage());
            return;
        }
        System.out.println("Обработка команды." +
                " Действие: " + command.getAction().name() + ", " +
                "Данные : " + command.getData());
    }

    private void processCreateCommand(Command command){
        String data = command.getData();
        String[] dataArr = data == null ? new String[0] : data.split(",", -1);

        if(dataArr.length != 5){
            System.out.println("Некорректный формат данных. Ожидается 5 полей через запятую: " +
                    "фамилия,имя,курс,город,возраст.");
            return;
        }

        Integer age;
        try {
            age = Integer.valueOf(dataArr[4].trim());
        } catch (NumberFormatException e) {
            System.out.println("Некорректный возраст: '" + dataArr[4].trim() + "'. Ожидается целое число.");
            return;
        }

        Student student = new Student();
        student.setSurname(dataArr[0].trim());
        student.setName(dataArr[1].trim());
        student.setCourse(dataArr[2].trim());
        student.setCity(dataArr[3].trim());
        student.setAge(age);

        studentStorage.createStudent(student);
        studentStorage.printAllStudents();
    }

    public void processUpdateCommand(Command command){
        String data = command.getData();
        String[] dataArr = data == null ? new String[0] : data.split(",", -1);

        if(dataArr.length != 6){
            System.out.println("Некорректный формат данных. Ожидается 6 полей через запятую: " +
                    "id,фамилия,имя,курс,город,возраст.");
            return;
        }

        Long id;
        try {
            id = Long.valueOf(dataArr[0].trim());
        } catch (NumberFormatException e) {
            System.out.println("Некорректный идентификатор: '" + dataArr[0].trim() + "'. Ожидается целое число.");
            return;
        }

        Integer age;
        try {
            age = Integer.valueOf(dataArr[5].trim());
        } catch (NumberFormatException e) {
            System.out.println("Некорректный возраст: '" + dataArr[5].trim() + "'. Ожидается целое число.");
            return;
        }

        Student student = new Student();
        student.setSurname(dataArr[1].trim());
        student.setName(dataArr[2].trim());
        student.setCourse(dataArr[3].trim());
        student.setCity(dataArr[4].trim());
        student.setAge(age);

        boolean updated = studentStorage.updateStudent(id, student);
        if(!updated){
            System.out.println("Студент с идентификатором " + id + " не найден.");
            return;
        }
        studentStorage.printAllStudents();
    }

    public void processDeleteCommand(Command command){
        String data = command.getData();
        Long id;
        try {
            id = Long.valueOf(data == null ? "" : data.trim());
        } catch (NumberFormatException e) {
            System.out.println("Некорректный идентификатор: '" + data + "'. Ожидается целое число.");
            return;
        }

        boolean deleted = studentStorage.deleteStudent(id);
        if(!deleted){
            System.out.println("Студент с идентификатором " + id + " не найден.");
        }
        studentStorage.printAllStudents();
    }

    private void processStatsByCourseCommand(Command command){
        Map<String, Long> data = studentStorage.getCountByCourse();
        studentStorage.printMap(data);
    }

    private void processSearchCommand(Command command){
        String surname = command.getData();
        studentStorage.search(surname);
    }

    private void processStatsByCityCommand(Command command){
        Map<String, Long> data = studentStorage.getCountByCity();
        studentStorage.printMap(data);
    }

    public StudentStorage getStudentStorage() {
        return studentStorage;
    }

    public void setStudentStorage(StudentStorage studentStorage) {
        this.studentStorage = studentStorage;
    }
}
