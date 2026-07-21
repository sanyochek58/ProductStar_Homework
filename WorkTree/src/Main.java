
public class Main {
    public static void main(String[] args) {
        BstTree bstTree = new BstTree();

        bstTree.add(20);
        bstTree.add(10);
        bstTree.add(25);
        bstTree.add(5);
        bstTree.add(15);
        bstTree.add(2);
        bstTree.add(6);

        System.out.println(bstTree.findMin());

    }
}