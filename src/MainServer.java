import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class MainServer {

    public static void main(String[] args) throws IOException {
        System.out.println("Starting server...");
        ServerSocket server = new ServerSocket(54321);
        while (true) {
            Socket socket = server.accept();
            new Thread(() -> {
                try {
                    System.out.println(socket.getPort() + " has connected");
                    InputStream is = socket.getInputStream();
                    String str = new String(is.readAllBytes(), StandardCharsets.UTF_8);
                    is.close();
                    System.out.println(socket.getPort() + " sent: " + str);
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }
}