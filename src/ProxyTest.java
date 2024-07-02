import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

public class ProxyTest {

    public static void main(String[] args) {
        //https://www.proxynova.com/proxy-server-list
        System.setProperty("http.proxyHost", "203.89.58.107");
        System.setProperty("http.proxyPort", "80");

        try{

            validateProxyServer("203.89.8.107", 80);
            URL url = new URL("http://example.com");

            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("203.89.8.107", 80));
            HttpURLConnection conn = (HttpURLConnection)  url.openConnection(proxy);

            conn.setRequestMethod("GET");

            InputStream input = conn.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            String line;
            StringBuilder response = new StringBuilder();
            while((line = reader.readLine()) !=null){
                response.append(line);
            }
            reader.close();
            System.out.println(response.toString());

            conn.disconnect();


        }catch (Exception e){
            System.out.println(e);
        }
    }

    private static void validateProxyServer(String proxyHost, int port){
        try (Socket socket = new Socket()){
            socket.connect(new InetSocketAddress(proxyHost, port), 5000);
            System.out.println("is reachable");

        }catch (Exception e){
            System.out.println(e);
        }
    }


}
