import java.io.IOException;
import java.util.List;

public interface UserService {
    List<User> loadFromFile() throws IOException;
    void saveToFile(User user) throws IOException;
    void addUser(User user) throws IOException;
}
