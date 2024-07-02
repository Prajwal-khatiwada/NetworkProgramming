import javax.imageio.IIOException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class OpenConnection {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/posts/");
            URLConnection connection = url.openConnection();
            InputStream stream = connection.getInputStream();
            int i;

            while ((i = stream.read()) != -1) {
                System.out.print((char) i);
            }
            System.out.println("\nURL HEADER=>Content Type:" + connection.getContentType());
            System.out.println("URL HEADER=>Content Length:" + connection.getContentLength());
        }catch(IIOException e)
        {
            System.out.println(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
