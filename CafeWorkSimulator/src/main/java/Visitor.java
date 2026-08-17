public class Visitor {

    private final int numVisitor;

    public Visitor(int numVisitor) {
        this.numVisitor = numVisitor;
    }

    public int getNumVisitor() {
        return numVisitor;
    }

    public void visit() {
        System.out.println("Посетитель " + numVisitor + " зашёл в кафе");
    }

}
