public class MyStack {

    static int size = 0;
    static int max_size = 5;
    static int[] data = new int[max_size];

    static void push(int value){
        if(size >= max_size){
            throw new RuntimeException("Stack is full!");
        }
        data[size] = value;
        size++;
    }

    static int pop(){
        if(size == 0){
            throw new RuntimeException("Stack is empty!");
        }
        int result = data[size - 1];
        size--;
        return result;
    }

    static int peek(){
        if(size == 0){
            throw new RuntimeException("Stack is empty!");
        }
        return data[size - 1];
    }

    static boolean isEmpty(){
        return size==0;
    }

    static void print(){
        if(size > 0){
            System.out.println("-------");
            for (int i = size - 1; i >= 0; i--) {
                System.out.println(" | " + data[i] + " | ");
            }
            System.out.println("-------");
        }
        else {
            if (isEmpty()){
                System.out.println("Stack is empty");
            }
            else  {
                System.out.println("Error!");
            }
        }
    }
}
