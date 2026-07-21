public class Main {
    public static void main(String[] args) {

        FamilyMember grandpa = new FamilyMember("Дед");
        FamilyMember father = grandpa.addChild("Отец");
        father.addChild("Сын");

        System.out.println("Дерево:");
        grandpa.printTree();
        
        // поиск родственников
        System.out.println("\nРодственники Отца:");
        System.out.println(father.findRelatives("Отец"));
    }
}