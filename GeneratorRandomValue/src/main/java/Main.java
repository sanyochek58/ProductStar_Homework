import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void initCharacters(ArrayList<String> characters){
        characters.add("Гном");
        characters.add("Принцесса");
        characters.add("Робот");
    }

    public static void initActions(ArrayList<String> actions){
        actions.add("летает");
        actions.add("ест");
        actions.add("сражается");
    }

    public static void initPlaces(ArrayList<String> places){
        places.add("в лесу");
        places.add("в космосе");
        places.add("на луне");
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        ArrayList<String> characters = new ArrayList<>();
        ArrayList<String> actions = new ArrayList<>();
        ArrayList<String> places = new ArrayList<>();

        initCharacters(characters);
        initActions(actions);
        initPlaces(places);

        while(true) {
            System.out.println("Героев: " + characters.size() + " Действий: " + actions.size() + " Мест: " + places.size());
            System.out.println("\n");
            System.out.println("Меню взаимодействия: \n" +
                                "1 - Добавить персонажа \n" +
                                "2 - Добавить действие \n" +
                                "3 - Добавить место \n" +
                                "4 - Сгенерировать историю \n" +
                                "5 - Выход \n");

            String act = input.nextLine();
            switch(act) {
                case "1":
                    System.out.println("Введите название нового героя: ");
                    String name = input.nextLine();
                    characters.add(name);
                    System.out.println("Добавлен новый герой: " + name);
                    break;

                case "2":
                    System.out.println("Введите новое действие: ");
                    String action = input.nextLine();
                    actions.add(action);
                    System.out.println("Добавлено новое действие: " + action);
                    break;

                case "3":
                    System.out.println("Введите новое место: ");
                    String place = input.nextLine();
                    places.add(place);
                    System.out.println("Добавлено новое место: " + place);
                    break;

                case "4":
                    System.out.println("\n\t История: \n");
                    System.out.println(characters.get(rand.nextInt(characters.size())) + " " + actions.get(rand.nextInt(actions.size())) + " " + places.get(rand.nextInt(places.size())) + "\n");
                    break;

                case "5":
                    System.exit(0);
                    break;

                default:
                    System.out.println("Ошибка, такого действия в меню нет !");
                    break;
            }
        }
    }
}
