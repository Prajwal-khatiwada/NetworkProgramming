import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class OpenStreamDemo {
    public static void main(String[] args) {
        try{
            URL url= new URL("https://jsonplaceholder.typicode.com/posts/");
            InputStream stream=url.openStream();
            int i;

            while ((i=stream.read())!=-1){
                System.out.print((char)i);
            }
        }catch (IOException e){
            System.out.println(e);
        }
    }
}
