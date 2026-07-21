import java.util.Scanner;

public class Main {

    private static boolean isValid(String string) {
        String regex = "^\\+\\d{1,3}[ -]?\\d{1,3}[ -]?[\\d -]{5,8}$";
        return string.matches(regex);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.print("Введите номер телефона: ");
            String phone = scanner.nextLine();
            try{
                System.out.println(isValid(phone));
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
