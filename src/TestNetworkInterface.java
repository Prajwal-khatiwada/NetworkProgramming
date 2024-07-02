import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class TestNetworkInterface {
    public static void main(String[] args) throws UnknownHostException {
        try {
            InetAddress local = InetAddress.getByName("127.0.0.1");
            NetworkInterface ni = NetworkInterface.getByInetAddress(local);
            InetAddress ip=InetAddress.getByName("0.0.0.0");
            NetworkInterface n = NetworkInterface.getByName("lo0");

            boolean reachable=ip.isReachable(n, 10,1000);
            System.out.println("Default: "+reachable);

            if (ni == null) {
                System.out.println("No network interface found");
            }

            System.out.println(ni);
        }catch (Exception e) {
            System.out.println(e);

        }

        try {
            Enumeration<NetworkInterface> ni = NetworkInterface.getNetworkInterfaces();

            if (ni == null) {
                System.out.println("No network interface found");
            }

            while (ni.hasMoreElements()) {
                NetworkInterface iface = ni.nextElement();
                System.out.println("Interface Name: " + iface.getName());
                System.out.println("Interface Display Name: " + iface.getDisplayName());
            }
        }catch (Exception e) {
            System.out.println("No network interface found");

        try{
            NetworkInterface ni = NetworkInterface.getByName("lo0");
            Enumeration<InetAddress> addresses = ni.getInetAddresses();

            if (ni == null) {
                System.out.println("No network interface found");
            }

            while (addresses.hasMoreElements()) {
                System.out.println("Ip address from network interface: " + addresses.nextElement());
            }
        }catch (SocketException ex){
            System.out.println("No network interface found");
        }
    }
}}