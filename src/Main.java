import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) {
        try {
            InetAddress ip=InetAddress.getByName("FF02:0:0:0:0:0:0:1");
            InetAddress ip2=InetAddress.getByName("230.0.0.1");
            InetAddress ip3=InetAddress.getByName("127.0.0.1");
            InetAddress ip4=InetAddress.getByName("0.0.0.0");
            System.out.println("Host Address:" + ip.getHostAddress());
            System.out.println("Host Name:" + ip.getHostName());
            System.out.println("Address:" + ip.getAddress());
            byte[] ipBytes = ip.getAddress();
            System.out.println("Address Length:" + ip.getAddress().length);
            System.out.println("Canonical Address:" + ip.getCanonicalHostName());
            System.out.println("Multicast Address:" + ip2.isMCGlobal());
            System.out.println("LookBack Address:" + ip3.isLoopbackAddress());
            System.out.println("Is Any Local Address:" + ip4.isAnyLocalAddress());

        } catch (UnknownHostException e){
            System.out.println("Unknown HostException" + e.getMessage());
        }
    }
}