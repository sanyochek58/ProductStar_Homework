import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {

        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        System.setErr(new PrintStream(System.err, true, StandardCharsets.UTF_8));

        CoworkingSystem system = new CoworkingSystem();

        WorkSpace workspace1 = new WorkSpace(1,"VIP", true);
        WorkSpace workspace2 = new WorkSpace(2,"STANDARD", true);
        WorkSpace workspace3 = new WorkSpace(3,"STANDARD", true);
        WorkSpace workspace4 = new WorkSpace(4,"STANDARD", true);
        WorkSpace workspace5 = new WorkSpace(5,"STANDARD", true);
        WorkSpace workspace6 = new WorkSpace(6,"VIP", true);

        system.addWorkspace(workspace1);
        system.addWorkspace(workspace2);
        system.addWorkspace(workspace3);
        system.addWorkspace(workspace4);
        system.addWorkspace(workspace5);
        system.addWorkspace(workspace6);

        User alex = new User("Alexandr", "Smith");
        User bob = new User("Bob", "Smith");

        system.registerUser(alex);
        system.registerUser(bob);

        system.bookWorkspace(alex, workspace1);
        system.bookWorkspace(bob, workspace2);

        System.out.println("Список доступных мест: ");
        system.printAvailableWorkspaces();
    }
}
