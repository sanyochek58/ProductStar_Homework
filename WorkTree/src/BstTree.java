public class BstTree {

    Node root;

    private Node addRecursive(Node current, int val) {
        if (current == null) {
            return new Node(val);
        }
        if(val < current.value){
            current.left = addRecursive(current.left, val);
        }
        else if(val > current.value){
            current.right = addRecursive(current.right, val);
        }
        return current;
    }

    private int findMinRecursive(Node current) {
        return current.left == null ? current.value : findMinRecursive(current.left);
    }

    public void add(int val){
        root = addRecursive(root, val);
    }

    public int findMin(){
        if(root == null){
            throw new RuntimeException("Дерево пустое!");
        }
        return findMinRecursive(root);
    }


}
