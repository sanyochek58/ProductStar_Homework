import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Chef {

    private List<String> orders = new ArrayList<>();
    private static final Random RANDOM = new Random();


    public List<String> getOrders() {
        return orders;
    }

    public void setOrders(List<String> orders) {
        this.orders = orders;
    }

    public String cook() {
        System.out.println("Шеф приступил к готовке");
        int choice = RANDOM.nextInt(3);
        switch (choice) {
            case 0 -> {
                System.out.println("Шеф приготовил " + Food.BURGER.name());
                orders.add(Food.BURGER.name());
                return Food.BURGER.name();
            }
            case 1 -> {
                System.out.println("Шеф приготовил " + Food.SOUP.name());
                orders.add(Food.SOUP.name());
                return Food.SOUP.name();
            }
            case 2 -> {
                System.out.println("Шеф приготовил " + Food.PIZZA.name());
                orders.add(Food.PIZZA.name());
                return Food.PIZZA.name();
            }
            default -> {
                System.out.println("Шеф ушёл в запой !");
                return null;
            }
        }
    }

}

