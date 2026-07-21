import java.util.Arrays;
import java.util.Random;

public class MusicPlaylist {

    static int max_size = 2;
    static int size = 0;
    static String[] data = new String[max_size];

    static void addSong(String title){
        if(size >= max_size){
            String[] temp = Arrays.copyOf(data, size);
            max_size *= 2;
            data = new String[max_size];

            for (int i = 0; i < temp.length; i++){
                data[i] = temp[i];
            }
        }
        data[size] = title;
        size++;
    }

    static void removeSong(int index){
        if(index < 0 || index >= max_size){
            throw new IndexOutOfBoundsException("Index out of bound!");
        }
        String[] temp = Arrays.copyOf(data, size);
        for(int i = index; i < temp.length - 1; i++){
            data[i] = temp[i+1];
        }
        data[temp.length-1] = null;
    }

    static void moveSong(int from, int to){
        if(from < 0 || from >= max_size || to < 0 || to >= max_size){
            throw new IndexOutOfBoundsException("Index out of bound!");
        }
        String[] temp = Arrays.copyOf(data, size);
        String song = data[from];

        for (int i = from; i < to; i++){
            data[i] = temp[i+1];
        }
        data[to] = song;
    }

    static void shuffle(){
        Random rand = new Random();
        for(int i = size - 1; i > 0; i--){
            int place = rand.nextInt(i + 1);
            String temp = data[i];
            data[i] = data[place];
            data[place] = temp;
        }
    }

    static void print(){
        if(size <= 0){
            throw new RuntimeException("Empty array!");
        }
        System.out.print("[");
        for(int i = 0; i <= size - 1; i++){
            if(i != size - 1)
                System.out.print(" " + data[i] + ", ");
            else
                System.out.print(data[i]);
        }
        System.out.println(" ]");
    }
}
