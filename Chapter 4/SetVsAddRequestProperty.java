import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class SetVsAddRequestProperty {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.example.com/");
            URLConnection uc = url.openConnection();

            //Set Request Property
            uc.setRequestProperty("User-Agent", "Mozilla/5.0");
            uc.setRequestProperty("User-Agent", "Chrome/9.0");

            //Add Request Property
            uc.addRequestProperty("Accept-Language", "en-US");
            uc.addRequestProperty("Accept-Language", "np-NP");

            Map<String, List<String>> requestProperties = uc.getRequestProperties();
            System.out.println("Headers:\n"+requestProperties);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
