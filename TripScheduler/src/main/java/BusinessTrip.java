import java.util.List;

public class BusinessTrip implements Trip {

    private final String from;
    private final String to;
    private final List<String> users;
    private final String duration;
    private final String description;

    @Override
    public void planTrip() {
        System.out.println("Планирование Бизнес-поездки");
    }

    @Override
    public List<String> getUsers() {
        return users;
    }

    public static final class Builder {
        private final String from;
        private final String to;
        private List<String> users;
        private String duration;
        private String description;

        public Builder(String from, String to) {
            this.from = from;
            this.to = to;
        }

        public Builder users(List<String> users) {
            this.users = users;
            return this;
        }

        public Builder duration(String duration) {
            this.duration = duration;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public BusinessTrip build() {
            return new BusinessTrip(this);
        }
    }

    private BusinessTrip(Builder builder) {
        this.from = builder.from;
        this.to = builder.to;
        this.users = builder.users;
        this.duration = builder.duration;
        this.description = builder.description;
    }
}

