import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void initInventory(LinkedHashMap<String, Integer> inventory) {
        inventory.put("Зелье здоровья", 5);
        inventory.put("Лук", 1);
        inventory.put("Стрелы", 9);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        LinkedHashMap<String, Integer> inventory = new LinkedHashMap<>();
        initInventory(inventory);

        System.out.println("Добро пожаловать в Инвентарь приключенца!\n");

        boolean running = true;
        while (running) {
            System.out.println(
                    "Выберите действие:\n" +
                            "1 - Добавить новый предмет\n" +
                            "2 - Изменить количество предметов\n" +
                            "3 - Удалить предмет\n" +
                            "4 - Найти предмет по названию\n" +
                            "5 - Показать весь интернет\n" +
                            "6 - Выход");

            String choice = input.nextLine();
            switch (choice) {
                case "1":
                    System.out.print("Введите название предмета: ");
                    String nameSubject = input.nextLine();
                    System.out.print("\n");
                    System.out.print("Введите количество: ");
                    String count = input.nextLine();
                    inventory.put(nameSubject, Integer.parseInt(count));
                    System.out.println("Предмет " + nameSubject + " успешно добавлен. \n");
                    break;

                case "2":
                    System.out.print("Введите название предмета: ");
                    String name = input.nextLine();
                    System.out.print("\n");
                    if (inventory.containsKey(name)) {
                        System.out.println("Введите количество: ");
                        String newCount = input.nextLine();
                        inventory.put(name, Integer.parseInt(newCount));
                        System.out.println("Количество " + name + " изменено. \n");
                    }
                    else {
                        System.out.println("Такого предмета в инвентаре нету");
                    }
                    break;

                case "3":
                    System.out.print("Введите название предмета: ");
                    String nameSub = input.nextLine();
                    System.out.print("\n");
                    if (inventory.containsKey(nameSub)) {
                        inventory.remove(nameSub);
                        System.out.println("Предмет " + nameSub + " удалён ! \n");
                    }else{
                        System.out.println("Такого предмета в инвентаре нету");
                    }
                    break;

                case "4":
                    System.out.print("Введите название предмета: ");
                    String nameSubFound = input.nextLine();
                    System.out.print("\n");
                    if (inventory.containsKey(nameSubFound)) {
                        System.out.println("Количество " + nameSubFound + ": " +  inventory.get(nameSubFound));
                    }else {
                        System.out.println("Такого предмета в инвентаре нету");
                    }
                    break;

                case "5":
                    System.out.println("Текущий инвентарь: \n");
                    for(Map.Entry<String, Integer> entry: inventory.entrySet()) {
                        System.out.println(entry.getKey() + " - " + entry.getValue());
                    }
                    break;

                case "6":
                    System.out.println("Выход из инвентаря !");
                    running = false;
                    break;

                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
                    break;
            }

            System.out.println();
        }
        input.close();
    }
}
