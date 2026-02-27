public enum Type {

    SEDAN("Легковой автомобиль"),
    SUV("Внедорожник"),
    PICKUP_TRUCK("Пикап");

    private final String abbrv;

    Type(String abbrv) {
        this.abbrv = abbrv;
    }

    public String getAbbrv() {
        return abbrv;
    }
}