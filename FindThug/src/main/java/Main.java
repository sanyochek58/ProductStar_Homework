import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void initEvidencesArchive(HashSet<String> archive){
        archive.add("Отпечаток пальца на тумбе");
        archive.add("Перчатка на столе");
        archive.add("Волос на раковине");
        archive.add("След на ковре");
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        HashSet<String> database = new HashSet<>();
        initEvidencesArchive(database);

        HashSet<String> evidences = new HashSet<>();
        System.out.println("Добро пожаловать в Детективную игру!\n");

        boolean running = true;
        while (running) {
            System.out.println(
                    "Выберите действие:\n" +
                    "1 - Добавить улику\n" +
                    "2 - Проверить наличие улики\n" +
                    "3 - Удалить улику\n" +
                    "4 - Сравнить с базой данных\n" +
                    "5 - Показать все найденные улики\n" +
                    "6 - Выход");

            String choice = input.nextLine();
            switch (choice) {
                case "1":
                    System.out.print("Введите название новой улики: ");
                    String evidence = input.nextLine();
                    if (evidences.contains(evidence)) {
                        System.out.println("Улика \"" + evidence + "\" уже есть в списке.");
                    } else {
                        evidences.add(evidence);
                        System.out.println("Улика \"" + evidence + "\" добавлена.");
                    }
                    break;

                case "2":
                    System.out.print("Введите название улики для проверки: ");
                    String evidenceName = input.nextLine();
                    if (evidences.contains(evidenceName)) {
                        System.out.println("Улика найдена.");
                    } else {
                        System.out.println("Улика не найдена.");
                    }
                    break;

                case "3":
                    System.out.print("Введите название улики для удаления: ");
                    String remEvidenceName = input.nextLine();
                    if (evidences.contains(remEvidenceName)) {
                        evidences.remove(remEvidenceName);
                        System.out.println("Улика \"" + remEvidenceName + "\" удалена.");
                    } else {
                        System.out.println("Улика \"" + remEvidenceName + "\" не найдена в списке.");
                    }
                    break;

                case "4":
                    System.out.println("Совпадения с базой данных:");
                    boolean hasMatches = false;
                    for (String ulica : evidences) {
                        if (database.contains(ulica)) {
                            System.out.println("- " + ulica);
                            hasMatches = true;
                        }
                    }
                    if (!hasMatches) {
                        System.out.println("Совпадений не найдено.");
                    }
                    break;

                case "5":
                    if (evidences.isEmpty()) {
                        System.out.println("Список найденных улик пуст.");
                    } else {
                        System.out.println("Найденные улики:");
                        for (String ulica : evidences) {
                            System.out.println("- " + ulica);
                        }
                    }
                    break;

                case "6":
                    System.out.println("Выход из игры. До встречи, детектив!");
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
