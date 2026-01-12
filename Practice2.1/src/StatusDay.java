import java.util.Scanner;

public class StatusDay {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите который час: ");
        int hour = input.nextInt();

        switch (hour) {
            case 6, 7, 8, 9, 10, 11:
                System.out.print("Это утро");
                break;

            case 12, 13, 14, 15, 16, 17:
                System.out.print("Это день");
                break;

            case 18, 19, 20, 21:
                System.out.print("Это вечер");
                break;

            case 22, 23, 0, 1, 2, 3, 4, 5:
                System.out.print("Это ночь");
                break;

            default:
                System.out.print("Ошибка ввода времени");
                break;
        }
    }
}