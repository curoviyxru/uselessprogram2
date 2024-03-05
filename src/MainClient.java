import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class MainClient {

    public static void main(String[] args) throws IOException {
        String str = "Hello, time is " + System.currentTimeMillis() + " now!";
        Socket socket = new Socket("server", 54321);
        OutputStream os = socket.getOutputStream();
        os.write(str.getBytes(StandardCharsets.UTF_8));
        os.close();
        socket.close();
        System.out.println("Has written \"" + str + "\" to localhost server");
    }
}
