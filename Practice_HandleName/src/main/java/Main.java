import java.util.Scanner;


public class Main {

    private static String editString(String input){
        int count = 0;

        String regex = "^[A-Za-zА-ЯЁа-яё][\\d_A-Za-zА-ЯЁа-яё]{2,19}$";
        boolean isValid = input.matches(regex);

        if(isValid){
            input = input.toLowerCase().replaceAll("_+","_");
            return input;
        }
        if (!isValid){
            for(int i = 0; i < input.length(); i++){
                if(Character.isDigit(input.charAt(i)) || Character.isWhitespace(input.charAt(i))){
                    return "Ошибка, имя должно начинаться с буквы!";
                }
            }
        }
        if(!isValid){
            for(int i = 0; i < input.length(); i++){
                if(Character.isLetter(input.charAt(i))){
                    return "Ошибка, имя должно быть от 3 до 20 символов";
                }
            }
        }
        return "Ошибка";
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Введите имя: ");
            String name = scanner.nextLine();
            try{
                System.out.println(editString(name));
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
