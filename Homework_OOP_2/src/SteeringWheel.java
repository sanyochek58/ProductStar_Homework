public class SteeringWheel implements Movable{

    @Override
    public void moveRight() {
        System.out.println("Руль повёрнут вправо!");
    }

    @Override
    public void moveLeft() {
        System.out.println("Руль повёрнут влево!");
    }
}
