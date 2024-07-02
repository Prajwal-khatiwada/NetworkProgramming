import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {
//    public static void main(String[] args) {
//        try {
//            URL url =new URL("http://www.google.com") ;
//            String path = "/search?q=apple";
//            URL complete= new URL(url,path);
//            System.out.println(complete);
//        }catch (MalformedURLException e){
//            System.out.println(e.getMessage());
//        }
public static void main(String[] args) {
    try {
        String protocol="http";
        String hostname="www.google.com";
        String path = "/search?q=ball";

        URL complete= new URL(protocol,hostname,path);
        System.out.println(complete);
    }catch (MalformedURLException e){
        System.out.println(e.getMessage());
    }
    }
}
