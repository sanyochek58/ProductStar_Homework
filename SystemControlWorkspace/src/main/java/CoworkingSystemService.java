public interface CoworkingSystemService {
    void addWorkspace(WorkSpace workSpace);
    boolean removeWorkspace(WorkSpace workSpace);
    void registerUser(User user);
    void bookWorkspace(User user, WorkSpace workSpace);
    void cancelBooking(User user, WorkSpace workSpace);
}
