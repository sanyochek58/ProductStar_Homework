public class SelectionSort {

    public static int[] selectionSort(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            int minIndexElement = i;
            for(int j = i + 1; j < arr.length; j++){
                if(minIndexElement > arr[j]){
                    minIndexElement = j;
                }
            }
            if(minIndexElement != i){
                int temp = arr[i];
                arr[i] = arr[minIndexElement];
                arr[minIndexElement] = temp;
            }
        }
        return arr;
    }
}
