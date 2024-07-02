import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketInputStreamExample {
    public static void main(String[] args) {
        try (Socket socket = new Socket("time.nist.gov", 13)) {
            InputStream in = socket.getInputStream();
            StringBuilder time = new StringBuilder();

            InputStreamReader isr = new InputStreamReader(in, "ASCII");
            for (int i = in.read(); i != -1; i = isr.read()) {
                time.append((char) i);
            }
            System.out.println(time.toString());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ;

    }
}
