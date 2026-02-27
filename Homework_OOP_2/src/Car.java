public class Car {
    private String name;
    private int power;
    private int weight;
    private Engine engine;
    private SteeringWheel steeringWheel;
    private Type type;

    public Car(String name, int power, int weight, Type type) {
        this.name = name;
        this.power = power;
        this.weight = weight;
        this.type = type;
        this.engine = new Engine();
        this.steeringWheel = new SteeringWheel();
    }

    public String getName() {
        return this.name;
    }
    public int getPower() {
        return this.power;
    }
    public int getWeight() {
        return this.weight;
    }
    public String getType() {
        return this.type.getAbbrv();
    }
    public Engine getEngine() {
        return this.engine;
    }


    public void setName(String name) {
        this.name = name;
    }
    public void setPower(int power) {
        this.power = power;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public void setType(Type type) {
        this.type = type;
    }

    public void startEngine(){
        engine.turnOn();
    }

    public void stopEngine(){
        engine.turnOff();
    }

    public void moveSteeringWheel(){
        steeringWheel.moveLeft();
        steeringWheel.moveRight();
    }
}

