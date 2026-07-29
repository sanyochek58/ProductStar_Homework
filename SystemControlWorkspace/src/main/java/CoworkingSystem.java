import java.util.TreeMap;
import java.util.TreeSet;

public class CoworkingSystem implements CoworkingSystemService{

    private TreeSet<WorkSpace> workspaces = new TreeSet<>();
    private TreeMap<User, TreeSet<WorkSpace>> userWorkspaces = new TreeMap<>();


    public TreeMap<User, TreeSet<WorkSpace>> getUserWorkspaces() {
        return userWorkspaces;
    }

    public void setUserWorkspaces(TreeMap<User, TreeSet<WorkSpace>> userWorkspaces) {
        this.userWorkspaces = userWorkspaces;
    }

    public TreeSet<WorkSpace> getWorkspaces() {
        return workspaces;
    }

    public void setWorkspaces(TreeSet<WorkSpace> workspaces) {
        this.workspaces = workspaces;
    }


    @Override
    public void addWorkspace(WorkSpace workSpace) {
        workspaces.add(workSpace);
        System.out.println("Добавлено место: " + workSpace.toString());
    }

    @Override
    public boolean removeWorkspace(WorkSpace workSpace) {
        if(!workspaces.contains(workSpace)){
            throw new WorkspaceNotFound("Такого рабочего места нет в системе !");
        }
        workspaces.remove(workSpace);
        System.out.println("Удалено место: " + workSpace.toString());
        return true;
    }

    @Override
    public void registerUser(User user) {
        if(!userWorkspaces.containsKey(user)){
            userWorkspaces.put(user, new TreeSet<>());
            System.out.println("Зарегистрирован новый пользователь: " + user.getName() + " " + user.getSurname() + ".");
        }else {
            throw new UserAlreadyRegisteredException("Пользователь уже зарегистрирован !");
        }
    }

    @Override
    public void bookWorkspace(User user, WorkSpace workSpace) {
        if(!userWorkspaces.containsKey(user)){
            throw new UserNotRegisteredException("Сначала пользователь должен зарегистрироваться в системе !");
        }
        if(!workspaces.contains(workSpace)){
            throw new WorkspaceNotFound("Такого рабочего места нет в системе !");
        }

        try {
            workSpace.markAsBooked();
        } catch (WorkspaceNotAvailableException e) {
            System.out.println(e.getMessage());
            return;
        }

        userWorkspaces.get(user).add(workSpace);
        System.out.println(user.getName() + " " + user.getSurname() + " бронирует рабочее место №" + workSpace.getNumber() + ".");
    }

    @Override
    public void cancelBooking(User user, WorkSpace workSpace) {
        if(!userWorkspaces.containsKey(user)){
            throw new UserNotFound("Такого пользователя нет !");
        }
        if(!workspaces.contains(workSpace)){
            throw new WorkspaceNotFound("Такого рабочего места нет в системе !");
        }
        if(!userWorkspaces.get(user).contains(workSpace)){
            throw new WorkspaceNotFound("Это место не было забронировано данным пользователем !");
        }

        workSpace.markAsAvailable();
        userWorkspaces.get(user).remove(workSpace);
        System.out.println(user.getName() + " " + user.getSurname() + " отменяет бронирование рабочего места №" + workSpace.getNumber() + ".");
    }

    public void printAvailableWorkspaces() {
        System.out.println("Список доступных рабочих мест:");

        TreeSet<WorkSpace> available = new TreeSet<>();
        for (WorkSpace workSpace : workspaces) {
            if (workSpace.isAvailable()) {
                available.add(workSpace);
            }
        }

        if (available.isEmpty()) {
            System.out.println("[пусто]");
            return;
        }

        int i = 1;
        for (WorkSpace workSpace : available) {
            System.out.println(i + ". №" + workSpace.getNumber() + ", тип: " + workSpace.getType() + ".");
            i++;
        }
    }
}
