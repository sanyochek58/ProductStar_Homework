import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StudentStorage {

    private Map<Long, Student> studentStorageMap = new HashMap<>();
    private StudentSurnameStorage studentSurnameStorage = new StudentSurnameStorage();
    private Long currentId = 0L;


    /**
     * Создание данных о студенте
     * @param student данные о студенте
     * @return сгенерированный уникальный идентификатор студента
     */
    public Long createStudent(Student student){
        Long nextId = getNextId();
        studentStorageMap.put(nextId, student);
        studentSurnameStorage.studentCreated(nextId, student.getSurname());
        return nextId;
    }

    /**
     * Обновление данных о студенте
     * @param id идентификатор студента
     * @param student данные студента
     * @return true если данные были обновлены, false если студент не был найден
     */
    public boolean updateStudent(Long id, Student student){
        if(!studentStorageMap.containsKey(id)){
            return false;
        }else{
            String newStudent = student.getSurname();
            String oldStudent = studentStorageMap.get(id).getSurname();
            studentSurnameStorage.studentUpdated(id,  oldStudent, newStudent);
            studentStorageMap.put(id, student);
            return true;
        }
    }

    /**
     * Удаление данных студента
     * @param id идентификатор студента
     * @return true если студент был удалён, false если студент не был найден
     */
    public boolean deleteStudent(Long id){
        Student removed = studentStorageMap.remove(id);
        if(removed != null){
            String surname = removed.getSurname();
            studentSurnameStorage.studentDeleted(id, surname);
        }
        return removed != null;
    }

    public void printAllStudents(){
        System.out.println(studentStorageMap);
    }

    public Long getNextId(){
        currentId = currentId + 1;
        return currentId;
    }

    public void printMap(Map<String, Long> map){
        map.entrySet().stream().forEach(
                entry -> {
                    System.out.println(entry.getKey() + " - " + entry.getValue());
                }
        );
    }

    public Map<String, Long> getCountByCourse(){
        Map<String, Long> res = studentStorageMap.values().stream().collect(Collectors.toMap(
                student -> student.getCourse(),
                student -> 1L,
                (count1, count2) -> count1 + count2
        ));

        return res;
    }

    /**
     * Поиск студентов по фамилии (или диапазону фамилий).
     * Пустая строка - вывод всех студентов.
     * Одна фамилия - точный поиск по фамилии.
     * Две фамилии через запятую - поиск студентов, чьи фамилии находятся в диапазоне между ними (включительно).
     * @param data строка поиска
     */
    public void search(String data){
        Set<Long> students;

        if(data == null || data.isBlank()){
            students = studentSurnameStorage.getAllStudentIds();
        }else{
            String[] surnames = data.split(",", -1);
            if(surnames.length == 1){
                students = studentSurnameStorage.getStudentsBySurname(surnames[0].trim());
            }else if(surnames.length == 2){
                students = studentSurnameStorage.getStudentsBySurnameRange(surnames[0].trim(), surnames[1].trim());
            }else{
                System.out.println("Некорректный формат поиска. Ожидается пустая строка, одна фамилия" +
                        " или две фамилии через запятую.");
                return;
            }
        }

        for(Long studentId : students){
            Student student = studentStorageMap.get(studentId);
            System.out.println(student);
        }
    }

    public Map<String, Long> getCountByCity(){
        return studentStorageMap.values().stream().collect(Collectors.toMap(
                Student::getCity,
                student -> 1L,
                Long::sum
        ));
    }


    public Map<Long, Student> getStudentStorageMap() {
        return studentStorageMap;
    }


    public void setStudentStorageMap(Map<Long, Student> studentStorageMap) {
        this.studentStorageMap = studentStorageMap;
    }

    public Long getCurrentId() {
        return currentId;
    }

    public void setCurrentId(Long currentId) {
        this.currentId = currentId;
    }

    public StudentSurnameStorage getStudentSurnameStorage() {
        return studentSurnameStorage;
    }

    public void setStudentSurnameStorage(StudentSurnameStorage studentSurnameStorage) {
        this.studentSurnameStorage = studentSurnameStorage;
    }
}
