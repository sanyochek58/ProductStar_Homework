public class Engine implements Functionable {

    @Override
    public void turnOn(){
        System.out.println("Двигатель запущен.");
    }

    @Override
    public void turnOff(){
        System.out.println("Двигатель заглушен.");
    }
}
