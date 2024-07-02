import java.net.URL;
import java.net.URLConnection;

public class ConfigureConnection {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.example.com/");
            URLConnection uc = url.openConnection();

            System.out.println("URL: " + uc.getURL());
            System.out.println("Allow user interaction: " + uc.getAllowUserInteraction());
            System.out.println("Do Output: " + uc.getDoOutput());
            System.out.println("Use Cache: " + uc.getUseCaches());

            uc.setAllowUserInteraction(true);
            uc.setDoOutput(true);
            uc.setUseCaches(false);

            System.out.println("\nAfter Setting:");
            System.out.println("URL: " + uc.getURL());
            System.out.println("Allow user interaction: " + uc.getAllowUserInteraction());
            System.out.println("Do Output: " + uc.getDoOutput());
            System.out.println("Use Cache: " + uc.getUseCaches());
            System.out.println("Default Cache: " + uc.getDefaultUseCaches());
            System.out.println("Default User Interaction: "+uc.getDefaultAllowUserInteraction());

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
