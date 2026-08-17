import java.util.ArrayList;
import java.util.List;

public class Cafe implements Runnable {

    private Chef chef = new Chef();
    private static final int FOOD_COUNT = 10;
    private static final int VISITOR_COUNT = 3;
    private static final int MAX_ATTEMPTS = 5;
    private boolean isEmpty = true;
    private volatile boolean cookingFinished = false;


    @Override
    public void run() {
        System.out.println("Кафе открыто");
        List<String> orders = chef.getOrders();

        Thread chefThread = new Thread(() -> {
            for (int i = 0; i < FOOD_COUNT; i++) {
                synchronized (orders) {
                    chef.cook();
                    orders.notifyAll();
                }
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            synchronized (orders) {
                cookingFinished = true;
                orders.notifyAll();
            }
        }, "Повар");
        chefThread.start();

        List<Thread> visitorThreads = new ArrayList<>();
        for (int i = 1; i <= VISITOR_COUNT; i++) {
            int visitorNum = i;
            new Visitor(visitorNum).visit();
            Thread visitorThread = new Thread(() -> {
                for (int attempt = 0; attempt < MAX_ATTEMPTS; attempt++) {
                    synchronized (orders) {
                        while (orders.isEmpty() && !cookingFinished) {
                            try {
                                orders.wait();
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                                return;
                            }
                        }
                        if (!orders.isEmpty()) {
                            String food = orders.remove(0);
                            isEmpty = orders.isEmpty();
                            System.out.println("Посетитель " + visitorNum + " съел " + food);
                        } else {
                            System.out.println("Посетитель " + visitorNum + " не дождался еды и ушёл");
                            return;
                        }
                    }
                }
            }, "Посетитель-" + visitorNum);
            visitorThreads.add(visitorThread);
            visitorThread.start();
        }

        try {
            chefThread.join();
            for (Thread t : visitorThreads) {
                t.join();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Кафе закрыто");
    }

    public Chef getChef() {
        return chef;
    }

    public void setChef(Chef chef) {
        this.chef = chef;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }
}
