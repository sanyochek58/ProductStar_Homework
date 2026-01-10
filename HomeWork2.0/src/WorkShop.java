import java.util.Arrays;

public class WorkShop {
    public static void main(String[] args){
        Friend[] friends = {
                new Friend("Kate", Integer.parseInt("14"), true, Float.parseFloat("12.3f")),
                new Friend("Jake", Integer.parseInt("18"), false, Float.parseFloat("0.0")),
                new Friend("Max",  Integer.parseInt("19"), true, Float.parseFloat("9.3")),
        };
        System.out.println("Friends: " + Arrays.toString(friends));
    }
}