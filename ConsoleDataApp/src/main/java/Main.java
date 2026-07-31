import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {

    private static StudentCommandHandler STUDENT_COMMAND_HANDLER = new StudentCommandHandler();

    public static void main(String[] args) {

        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        System.setIn(System.in);

        while(true){
            printMessage();
            Command command = readCommand();
            if(command.getAction() == Action.EXIT){
                return;
            }else if (command.getAction() == Action.ERROR){
                continue;
            }else {
                STUDENT_COMMAND_HANDLER.processCommand(command);
            }

        }
    }

    private static void printMessage(){
        System.out.println("------------------------");
        System.out.println("0. Выход");
        System.out.println("1. Создание данных");
        System.out.println("2. Обновление данных");
        System.out.println("3. Удаление данных");
        System.out.println("4. Вывод статистики по курсам");
        System.out.println("5. Поиск по фамилии");
        System.out.println("6. Вывод статистики по городам");
        System.out.println("------------------------");
    }

    private static Command readCommand(){
        Scanner input = new Scanner(System.in, StandardCharsets.UTF_8);
        try{
            String code =  input.nextLine();
            Integer actionCode = Integer.valueOf(code);
            Action action = Action.fromCode(actionCode);
            if(action.isRequireAdditionalData()){
                String data = input.nextLine();
                return new Command(action, data);
            }else{
                return new Command(action);
            }
        }catch(Exception e){
            System.out.println("Проблема обработки ввода. " + e.getMessage());
            return new Command(Action.ERROR);
        }

    }

    public static StudentCommandHandler getStudentCommandHandler() {
        return STUDENT_COMMAND_HANDLER;
    }

    public static void setStudentCommandHandler(StudentCommandHandler studentCommandHandler) {
        STUDENT_COMMAND_HANDLER = studentCommandHandler;
    }
}
