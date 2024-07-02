import java.net.URL;
import java.net.URLConnection;
import java.util.*;


public class HeaderViewer {
    public static void main(String[] args) {
        try {


    URL url= new URL("https://www.example.com/");
        URLConnection uc= url.openConnection();
        System.out.println("Content-Type:" + uc.getContentType());

//        String contentType = uc.getHeaderField("Content-Type");
//        System.out.println("Content-Type:" + contentType);

        System.out.println("Content-Length:" + uc.getContentLength());
        if(uc.getContentEncoding()!=null){
            System.out.println("Content-Encoding:" + uc.getContentEncoding());
        }

        if(uc.getDate()!=0){
            System.out.println("Date:" + new Date(uc.getDate()));
        }

        if(uc.getLastModified()!=0){
            System.out.println("Last-Modified:" + new Date(uc.getLastModified()));
        }

        if(uc.getExpiration()!=0){
            System.out.println("Expiration:" + new Date(uc.getExpiration()));
        }

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
