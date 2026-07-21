import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FamilyMember {

    private String name;
    private List<FamilyMember> parents = new ArrayList<>();
    private List<FamilyMember> children = new ArrayList<>();

    public FamilyMember(String name) {
        this.name = name;
    }

    public FamilyMember addChild(String name) {
        FamilyMember child = new FamilyMember(name);
        children.add(child);
        child.parents.add(this);
        return child;
    }

    public FamilyMember addParent(String name) {
        FamilyMember parent = new FamilyMember(name);
        parents.add(parent);
        parent.children.add(this);
        return parent;
    }

    public Set<String> findRelatives(String name) {
        Set<String> relatives = new HashSet<>();
        if (this.name.equals(name)) {
            for (FamilyMember p : parents) {
                relatives.add("Родитель: " + p.name);
            }
            for (FamilyMember c : children) {
                relatives.add("Ребёнок: " + c.name);
            }
        }
        return relatives;
    }

    public void printTree() {
        printTree(this, 0);
    }

    private void printTree(FamilyMember memeber, int level) {
        System.out.println(" ".repeat(level) + memeber.name);
        for(FamilyMember child: memeber.children) {
            printTree(child, level + 1);
        }
    }
}