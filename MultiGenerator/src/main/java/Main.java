import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Main implements Runnable {

    private static final Random RANDOM = new Random();

    private static final int SIZE = 100000;
    private final int[] values = new int[SIZE];


    private AtomicInteger atomicIntegerOne = new AtomicInteger(0);
    private AtomicInteger atomicIntegerTwo = new AtomicInteger(0);
    private AtomicInteger atomicIntegerThree = new AtomicInteger(0);


    public static void main(String[] args) {

        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        Main main = new Main();
        main.run();
    }

    @Override
    public void run() {
        generateValue();
        System.out.println("Начало работы по обработке чисел...");

        Thread twoDigitThread = new Thread(() -> {
            for (int value : values) {
                if (value >= 10 && value <= 99) {
                    atomicIntegerOne.incrementAndGet();
                }
            }
        });

        Thread threeDigitThread = new Thread(() -> {
            for (int value : values) {
                if (value >= 100 && value <= 999) {
                    atomicIntegerTwo.incrementAndGet();
                }
            }
        });

        Thread fourDigitThread = new Thread(() -> {
            for (int value : values) {
                if (value >= 1000 && value <= 9999) {
                    atomicIntegerThree.incrementAndGet();
                }
            }
        });

        twoDigitThread.start();
        threeDigitThread.start();
        fourDigitThread.start();

        try {
            twoDigitThread.join();
            threeDigitThread.join();
            fourDigitThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Двузначных чисел: " + atomicIntegerOne + " шт.\n" +
                "Трёхзначных чисел: " + atomicIntegerTwo + " шт.\n" +
                "Четырёхзначных чисел: " + atomicIntegerThree + " шт.");
    }

    public int generateNumber(int min, int max) {
        return RANDOM.nextInt(min, max + 1);
    }

    public void generateValue(){
        System.out.println("Генерация чисел...");
        for (int i = 0; i < SIZE; i++) {
            values[i] = generateNumber(10, 9999);
        }
        System.out.println("Массив сгенерирован !");
    }

    public AtomicInteger getAtomicIntegerOne() {
        return atomicIntegerOne;
    }

    public void setAtomicIntegerOne(AtomicInteger atomicIntegerOne) {
        this.atomicIntegerOne = atomicIntegerOne;
    }

    public AtomicInteger getAtomicIntegerTwo() {
        return atomicIntegerTwo;
    }

    public void setAtomicIntegerTwo(AtomicInteger atomicIntegerTwo) {
        this.atomicIntegerTwo = atomicIntegerTwo;
    }

    public AtomicInteger getAtomicIntegerThree() {
        return atomicIntegerThree;
    }

    public void setAtomicIntegerThree(AtomicInteger atomicIntegerThree) {
        this.atomicIntegerThree = atomicIntegerThree;
    }

    public int[] getValues() {
        return values;
    }
}
