import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        UserManager userManager = new UserManager();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("Выберите действие:");
            System.out.println("1 - Добавить пользователя");
            System.out.println("2 - Показать список пользователей");
            System.out.println("3 - Выход");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.println("Введите имя пользователя:");
                    String name = scanner.nextLine();
                    System.out.println("Введите город пользователя:");
                    String city = scanner.nextLine();

                    userManager.addUser(new User(name, city));
                }
                case "2" -> {
                    System.out.println();
                    System.out.println("Список пользователей:");
                    for (User user : userManager.getUsers()) {
                        System.out.println("Имя: " + user.getName() + ", Город: " + user.getCity());
                    }
                }
                case "3" -> {
                    System.out.println("Выход из программы.");
                    running = false;
                }
                default -> System.out.println("Некорректный выбор, попробуйте снова.");
            }

            System.out.println();
        }

        scanner.close();
    }
}
