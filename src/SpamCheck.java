import java.net.InetAddress;
import java.net.UnknownHostException;

public class SpamCheck {
    public static final String blackhole="sbl.spamhaus.org";

    private static boolean isSpam(String addr){
        try{
            String query=blackhole;
            InetAddress ia= InetAddress.getByName(addr);
            byte[] bytes= ia.getAddress();
            for(byte b:bytes){
                int a=b<0?b+256:b;
                query =a+"."+query;
            }
            InetAddress ip2=InetAddress.getByName(query);
            System.out.println(ip2.getHostAddress());
            return true;
        }catch (UnknownHostException e) {
            return false;
        }
    }
    public static void main(String[] args) {
        String[] address= {"80.82.77.139","192.168.1.1","93.174.95.106"};
        for(String addr:address){
            boolean is = isSpam(addr);
            System.out.println(addr);
            System.out.println(" Is Spam(True/False?: )" + is);
        }

    }
}
