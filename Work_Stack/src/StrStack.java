import java.util.Arrays;

public class StrStack {
    static int max_size = 6;
    static int size = 0;
    static char[] stack = new char[max_size];

    static String reverseWord(){
        StringBuilder buffer = new StringBuilder();
        if (size == 0){
            throw new RuntimeException("Stack is empty!");
        }
        char[] temp = Arrays.copyOf(stack, size);
        for (int i = size-1; i >= 0; i--){
            buffer.append(temp[i]);
        }
        return buffer.toString();
    }

    static char peek(){
        if (size == 0){
            throw new RuntimeException("Stack is empty!");
        }
        return stack[size - 1];
    }

    static char pop(){
        if(size == 0){
            throw new RuntimeException("Stack is empty!");
        }
        char result = stack[size - 1];
        size--;
        return result;
    }

    static void push(String word){
        if(size >= max_size){
            throw new RuntimeException("Stack is full!");
        }
        if(word.length() > max_size){
            throw new RuntimeException("Word size is so big!");
        }
        for(char ch : word.toCharArray()){
            stack[size] = ch;
            size++;
        }
    }

    static void print(){
        if(size > 0){
            System.out.println("------");
            for (int i = size - 1; i >= 0; i--) {
                System.out.println(" | " + stack[i] + " | ");
            }
            System.out.println("------");
        }
        else {
            if (isEmpty()){
                System.out.println("Stack is empty!");
            }
            else {
                System.out.println("Error!");
            }
        }
    }

    static boolean isEmpty(){
        return size == 0;
    }

    static void clear(){
        size = 0;
    }
}
