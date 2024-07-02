import java.net.URL;
import java.net.URLConnection;

public class AllHeaders {
    public static void main(String[] args) {
          for (int i = 1;; i++) {
              try {
                  URL url = new URL("http://www.google.com");
                  URLConnection connection = url.openConnection();
                  if(connection.getHeaderField(i)==null)
                      break;
                  System.out.println(connection.getHeaderFieldKey(i)+": "+connection.getHeaderField(i));

      }catch (Exception e) {
                  System.out.println(e);
              }
      }
    }
}
