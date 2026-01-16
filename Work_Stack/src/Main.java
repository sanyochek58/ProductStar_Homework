public class Main {
    public static void main(String[] args) {
        MyStack.push(1);
        MyStack.push(2);
        MyStack.push(3);
        MyStack.push(4);
        MyStack.push(5);

        MyStack.print();
        System.out.println(MyStack.pop());

        MyStack.print();

        System.out.println(MyStack.peek());
    }
}