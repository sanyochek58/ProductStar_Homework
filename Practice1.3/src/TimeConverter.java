import java.util.Scanner;

public class TimeConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите количество минут: ");
        int minutes =  input.nextInt();

        int hours = minutes/60;
        minutes = minutes%60;

        System.out.print("Это равно: " + hours + " часов " + minutes + " минут");
    }
}
