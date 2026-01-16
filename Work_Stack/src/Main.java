import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Тесты с классическим стеком

        MyStack.push(1);
        MyStack.push(2);
        MyStack.push(3);
        MyStack.push(4);
        MyStack.push(5);

        MyStack.print();
        System.out.println(MyStack.pop());

        MyStack.print();

        System.out.println(MyStack.peek());

        // Тесты с кастомным строковым стеком
        System.out.println("Ввеедите слово из 6 букв, которое преобразуем с помощью стека : ");
        String word = input.nextLine();

        StrStack.clear();

        StrStack.push(word);

        StrStack.print();

        System.out.println(StrStack.peek());

        //System.out.println(StrStack.pop());

        StrStack.print();

        System.out.println("Перевёрнутое слов : " + StrStack.reverseWord());


    }
}