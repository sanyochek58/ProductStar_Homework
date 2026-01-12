import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Игра угадайка");
        int target = random.nextInt(100) + 1;
        int attempts = 0;

        int value;

        do{
            System.out.print("Введите число: ");
            value = input.nextInt();
            attempts++;
            if(value > target)
                System.out.println("Меньше");
            else if(value < target)
                System.out.println("Больше");
        }while (value != target);
        System.out.print("ПОБЕДА!!! Количество попыток : " + attempts );
    }
}
