import java.util.Scanner;

public class Checker {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String word = sc.nextLine();

        System.out.println(HTMLValidator.checkString(word));
        HTMLValidator.print();
    }
}