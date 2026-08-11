import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class EchoClient {
    public static void main(String[] args) throws IOException {

        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        System.setErr(new PrintStream(System.err, true, StandardCharsets.UTF_8));

        int port = 8080;
        String serverAddress = "127.0.0.1";

        try(Socket socket = new Socket(serverAddress, port)) {
            System.out.println("Подключение к серверу ...");

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            String msg = "Привет, серверок !";

            writer.println(msg);

            System.out.println("Отправлено сообщение: " + msg);

            String response = reader.readLine();
            System.out.println("Ответ от сервера: " + response);
        } catch (IOException e) {
            System.err.println("Ошибка клиента: " + e.getMessage());
        }

    }
}
