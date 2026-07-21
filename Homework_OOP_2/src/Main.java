public class Main {
    public static void main(String[] args) {
        Car car = new Car("AUDI",540, 1200, Type.SEDAN);

        System.out.println("Управляем автомобилем: " + car.getName());
        car.startEngine();
        car.moveSteeringWheel();
        car.stopEngine();
    }
}