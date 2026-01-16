public class Main {
    public static void main(String[] args) {

        System.out.println(DynamicArray.isEmpty());

        DynamicArray.add(1);
        DynamicArray.add(2);
        DynamicArray.add(3);

        DynamicArray.print();
        System.out.println();

        System.out.println(DynamicArray.isEmpty());

        System.out.println(DynamicArray.contains(1));

        DynamicArray.remove(0);

        System.out.println(DynamicArray.contains(1));

        System.out.println(DynamicArray.get(1));
        System.out.println(DynamicArray.get(2));

        DynamicArray.print();
        System.out.println();

        System.out.println(DynamicArray.indexOf(3));

    }
}