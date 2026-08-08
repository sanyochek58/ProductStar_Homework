import java.util.List;

public class TripFactory {

    public Trip createTrip(String type, String from, String to, List<String> users, String duration, String description) {
        return switch (type){
            case "excursion" -> new ExcursionTrip.Builder(from, to)
                    .users(users)
                    .duration(duration)
                    .description(description)
                    .build();
            case "business" -> new BusinessTrip.Builder(from, to)
                    .users(users)
                    .duration(duration)
                    .description(description)
                    .build();
            default -> null;
        };
    }
}
