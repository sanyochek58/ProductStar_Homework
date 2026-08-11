import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class EchoServer {
    public static void main(String[] args) {

        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        System.setErr(new PrintStream(System.err, true, StandardCharsets.UTF_8));

        int port = 8080;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен. Ожидание подключения " + port);

            while (true){
                Socket socket = serverSocket.accept();
                System.out.println("Клиент подключился: " + socket.getInetAddress());

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String message = in.readLine();
                System.out.println("Получено сообщение: " + message);

                out.println("Эхо: " + message);

                socket.close();
            }
        } catch (IOException e) {
            throw new RuntimeException("Ошибка сервера: " + e);
        }
    }
}
