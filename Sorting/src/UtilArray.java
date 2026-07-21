import java.util.Random;

public class UtilArray {

    private static final Random random = new Random();

    public static int[] generate(int[] arr, int size){
        for(int i = 0; i < size; i++){
            arr[i] = random.nextInt(10000);
        }
        return arr;
    }
}
