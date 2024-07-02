import java.net.InetSocketAddress;
import java.net.Socket;

public class SocketGetMethod {
    public static void main(String[] args) {
        Socket socket = null;
        try {
             socket = new Socket();
            String host = "google.com";
            int port = 80;
            socket.connect(new InetSocketAddress(host, port));

            System.out.println(socket.getInetAddress());
            System.out.println(socket.getPort());
            System.out.println(socket.getLocalAddress());
            System.out.println(socket.getLocalPort());

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            if (socket != null)
            try {
                socket.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
