import java.util.*;

public class Area {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите длину прямоугольника: ");
        float length = input.nextFloat();
        System.out.print("Введите ширину прямоугольника: ");
        float width = input.nextFloat();

        float result = length * width;

        System.out.print("Площадь прямоугольника : " + result);
    }
}