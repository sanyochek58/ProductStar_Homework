import java.util.TreeSet;
import java.util.UUID;

public class User implements Comparable<User>, UserService{

    private String name;
    private String surname;
    private UUID id;
    private TreeSet<WorkSpace> workSpaces;

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;

        this.id = UUID.randomUUID();
        this.workSpaces = new TreeSet<>();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public UUID getId() {
        return id;
    }

    public TreeSet<WorkSpace> getWorkSpaces() {
        return workSpaces;
    }

    @Override
    public void bookWorkSpace(WorkSpace workSpace) {
        workSpace.markAsBooked();
        workSpaces.add(workSpace);
    }

    @Override
    public void cancelBooking(WorkSpace workSpace) {
        if (!workSpaces.contains(workSpace)) {
            throw new WorkspaceNotFound("Это место не было забронировано данным пользователем!");
        }
        workSpace.markAsAvailable();
        workSpaces.remove(workSpace);
    }

    @Override
    public int compareTo(User o) {
        int surnameCompare = this.surname.compareTo(o.surname);
        if (surnameCompare != 0) {
            return surnameCompare;
        }
        return this.name.compareTo(o.name);
    }
}
