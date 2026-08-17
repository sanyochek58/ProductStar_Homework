import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class UserManager implements UserService {

    private static final String FILENAME = "users.txt";

    private List<User> users;

    public UserManager() {
        this.users = loadFromFile();
    }

    public List<User> getUsers() {
        return users;
    }

    @Override
    public void addUser(User user) {
        users.add(user);
        saveToFile(user);
    }

    @Override
    public void saveToFile(User user) {
        String line = user.getName() + "," + user.getCity() + System.lineSeparator();
        try {
            Files.write(
                    Path.of(FILENAME),
                    line.getBytes(StandardCharsets.UTF_8),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private String[] handleLine(String line) {
        if (line.isBlank()) {
            return null;
        }
        return line.split(",");
    }

    @Override
    public List<User> loadFromFile() {
        List<User> loaded = new ArrayList<>();
        Path path = Path.of(FILENAME);
        if (!Files.exists(path)) {
            return loaded;
        }
        try {
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            for (String line : lines) {
                String[] parts = handleLine(line);
                if (parts != null && parts.length == 2) {
                    loaded.add(new User(parts[0], parts[1]));
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return loaded;
    }
}
