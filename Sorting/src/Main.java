import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        int arraySize = 100000;
        int[] array = new int[arraySize];

        UtilArray.generate(array, arraySize);

        Long start = System.currentTimeMillis();
        int[] sorted1 = BubbleSort.bubbleSort(array);
        Long end = System.currentTimeMillis();

        System.out.println(Arrays.toString(sorted1));
        System.out.println("Время выполнения пузырьковой сортировки: " + ((end - start)/1000) + " с");

        Thread.sleep(1000);

        UtilArray.generate(array, arraySize);

        start = System.currentTimeMillis();
        int[] sorted2 = BubbleSort.bubbleSort(array);
        end = System.currentTimeMillis();

        System.out.println(Arrays.toString(sorted1));
        System.out.println("Время выполнения пузырьковой сортировки (оптимизированный): " + ((end - start)/1000) + " с");

        Thread.sleep(5000);

        UtilArray.generate(array, arraySize);

        start = System.currentTimeMillis();
        Arrays.sort(array);
        end = System.currentTimeMillis();

        System.out.println(Arrays.toString(array));
        System.out.println("Время выполнения TimSort сортировки: " + ((end - start)/1000) + " c");

        Thread.sleep(5000);

        UtilArray.generate(array, arraySize);

        start = System.currentTimeMillis();
        int[] sorted3 = InsertionSort.insertionSort(array);
        end = System.currentTimeMillis();

        System.out.println(Arrays.toString(array));
        System.out.println("Время выполнения сортировки вставками: " + ((end - start) / 1000) + " c");

        Thread.sleep(5000);

        UtilArray.generate(array, arraySize);

        start = System.currentTimeMillis();
        int[] sorted4 = SelectionSort.selectionSort(array);
        end = System.currentTimeMillis();

        System.out.println(Arrays.toString(array));
        System.out.println("Время выполнения сортировки выборкой: " + ((end - start) / 1000) + " c");
    }
}