import java.util.*;

public class HomeWork {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Как зовут вашего друга ?");
        String name = input.nextLine();

        System.out.println("Сколько лет вашему другу ?");
        String age = input.nextLine();

        System.out.println("Вашего другах зовут " + name + " ему " + age + " лет");
    }
}