import java.util.List;

public class Main {

    public static void main(String[] args) {
        TripManager tripManager = TripManager.getInstance();

        TripObserver emailNotifier = trip -> {
            System.out.println("[Email] Новая поездка назначена. Участники: " + trip.getUsers());
            trip.planTrip();
        };

        TripObserver smsNotifier = trip -> {
            System.out.println("[SMS] Новая поездка назначена. Участники: " + trip.getUsers());
            trip.planTrip();
        };

        tripManager.addObserver(emailNotifier);
        tripManager.addObserver(smsNotifier);

        TripFactory factory = new TripFactory();

        System.out.println("=== Назначаем бизнес-поездку ===");
        Trip businessTrip = factory.createTrip(
                "business", "Москва", "Санкт-Петербург",
                List.of("Иванов", "Петров"), "3 дня", "Переговоры с партнёрами");
        tripManager.setCurrentTrip(businessTrip);

        System.out.println();
        System.out.println("=== Отписываем SMS-уведомление ===");
        tripManager.removeObserver(smsNotifier);

        System.out.println();
        System.out.println("=== Назначаем экскурсионную поездку ===");
        Trip excursionTrip = factory.createTrip(
                "excursion", "Казань", "Свияжск",
                List.of("Сидоров", "Кузнецова", "Смирнов"), "1 день", "Обзорная экскурсия");
        tripManager.setCurrentTrip(excursionTrip);
    }
}
