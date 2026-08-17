public enum Food {

    SOUP("Суп"),
    BURGER("Бургер"),
    PIZZA("Пицца");

    private final String message;

    Food(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
