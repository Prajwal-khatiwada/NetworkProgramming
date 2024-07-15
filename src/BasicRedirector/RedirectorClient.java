package BasicRedirector;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RedirectorClient {
    private static final String host = "localhost";
    private static final int port = 8009;
    private static final Logger logger = Logger.getLogger(RedirectorClient.class.getName());

    public static void main(String[] args) {
        try (Socket socket = new Socket(host, port);
             PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            out.println("GET/old-resource-path HTTP/1.1");
            out.println("Host: " + host);

            String responseLine;
            while ((responseLine = in.readLine()) != null) {
                System.out.println(responseLine);
            }

        } catch (IOException e) {
            logger.log(Level.SEVERE, "Client error", e);
        }
    }
}
