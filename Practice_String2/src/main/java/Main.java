import java.util.Scanner;

public class Main {

    private static String handleString(String input){
        String regex = "[а-яёА-ЯЁ: ]+";
        return input.replaceAll(regex, "");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.print("Ввод: ");
            String input = scanner.nextLine();
            try{
                System.out.println("Вывод: " + handleString(input));
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

    }
}
