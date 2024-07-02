import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ConnectFromLocalInterface {
    public static void main(String[] args) {
        try {
            InetAddress url = InetAddress.getByName("time.nist.gov");
            InetAddress localInterface = InetAddress.getByName("192.168.16.109");

            Socket socket = new Socket(url, 13, localInterface, 0);
            socket.setSoTimeout(15000);
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
    }
}
