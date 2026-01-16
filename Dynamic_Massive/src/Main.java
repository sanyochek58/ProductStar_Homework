public class Main {
    public static void main(String[] args) {

        System.out.println(DynamicArray.isEmpty());

        System.out.println("Array before sorting");
        DynamicArray.add(7);
        DynamicArray.add(6);
        DynamicArray.add(5);
        DynamicArray.add(4);
        DynamicArray.add(3);
        DynamicArray.add(2);
        DynamicArray.add(1);

        DynamicArray.print();
        System.out.println();

        DynamicArray.sort();
        System.out.println("Array after sorting");
        DynamicArray.print();
//        System.out.println();
//
//        System.out.println(DynamicArray.isEmpty());
//
//        System.out.println(DynamicArray.contains(1));
//
//        DynamicArray.remove(0);
//
//        System.out.println(DynamicArray.contains(1));
//
//        System.out.println(DynamicArray.get(1));
//        System.out.println(DynamicArray.get(2));
//
//        DynamicArray.print();
//        System.out.println();
//
//        System.out.println(DynamicArray.indexOf(3));

    }
}