import java.net.ConnectException;
import java.net.Socket;

public class PortScanner {
    public static void main(String[] args) {
        String host = "127.0.0.1";
        for (int i = 1; i < 65535; i++) {
            try (Socket socket = new Socket(host, i)) {
                System.out.println("Port " + i + " is occupied");
            } catch (ConnectException e) {
                //
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
