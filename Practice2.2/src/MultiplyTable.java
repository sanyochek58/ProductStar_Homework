import java.util.Scanner;

public class MultiplyTable {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите число от 1 до 9: ");
        short value = input.nextShort();

        if(value < 1 || value > 9) {
            System.out.print("Ошибка диапазона введённого числа");
        }
        else {
            for(int i = 1; i <= 10; i++) {
                System.out.println(value + " x " + i + " = " + value * i);
            }
        }

    }
}