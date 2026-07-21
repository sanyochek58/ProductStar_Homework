import java.util.Scanner;

public class Temperature {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите температуру в градусах Цельсия: ");
        float temperature = input.nextFloat();

        double result = temperature * 1.8 + 32;

        System.out.print("Температура в градусах Фаренгейта: " + result);
    }
}