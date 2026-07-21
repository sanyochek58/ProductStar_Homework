import java.util.Arrays;

public class DynamicArray {
    static int size = 0;
    static int max_size = 2;
    static int[] data = new int[max_size];

    static void print(){
        System.out.print("[");
        for(int i=0;i<size;i++){
            System.out.print(" " + data[i] + " ");
        }
        System.out.print("]");
    }

    static void add(int value){
        if(size >= max_size){
            int[] temp = Arrays.copyOf(data,size);
            max_size *= 2;
            data = new int[max_size];

            for (int i=0;i<temp.length;i++){
                data[i] = temp[i];
            }
        }
        data[size]=value;
        size++;
    }

    static boolean isEmpty(){
        return size == 0;
    }

    static void remove(int index){
        if(index < 0 || index >= max_size){
            throw new IndexOutOfBoundsException("Index out of bound!");
        }
        int[] temp = Arrays.copyOf(data,size);
        for (int i = index; i < temp.length - 1; i++){
            data[i] = temp[i+1];
        }
        data[temp.length - 1] = 0;
    }

    static boolean contains(int value){
        return indexOf(value) > -1;
    }

    static int indexOf(int value){
        for (int i=0;i<size;i++){
            if(data[i]==value){
                return i;
            }
        }
        return -1;
    }

    static int get(int index){
        if(index < 0 || index >= max_size){
            throw new IndexOutOfBoundsException("Index out of bound!");
        }
        return data[index];
    }

    static void sort(){
        if(size == 0){
            throw new IndexOutOfBoundsException("Array is empty!");
        }
        for (int i = 0; i < size - 1; i++) {
            for (int n = i + 1; n < size; n++) {
                if(data[i] > data[n]) {
                    int temp = data[i];
                    data[i] = data[n];
                    data[n] = temp;
                }
            }
        }
    }

}
