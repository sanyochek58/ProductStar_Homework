public class TestCircle {

    public static void test() {
        testInit();
        testSetter();
        testArea();

        System.out.println("Все тесты пройдены");
    }

    public static void testInit() {
        Circle circle = new Circle(5.0);

        if (circle.getRadius() != 5.0) {
            System.out.println("testInit FAILED");
            return;
        }

        System.out.println("testInit PASSED");
    }

    public static void testSetter() {
        Circle circle = new Circle(3.0);
        circle.setRadius(7.0);

        if (circle.getRadius() != 7.0) {
            System.out.println("testSetter FAILED");
            return;
        }

        System.out.println("testSetter PASSED");
    }

    public static void testArea() {
        Circle circle = new Circle(2.0);
        double expected = Math.PI * 4;
        double actual = circle.getArea();

        if (Math.abs(expected - actual) > 0.0001) {
            System.out.println("testArea FAILED");
            return;
        }

        System.out.println("testArea PASSED");
    }
}