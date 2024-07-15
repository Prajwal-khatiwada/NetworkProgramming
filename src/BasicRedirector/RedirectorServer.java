package BasicRedirector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import static javax.swing.text.html.HTML.Tag.*;

public class RedirectorServer {
    private final static int port = 8009;
    private final static String newsite = "new-resource-path";
    private static final Logger logger = Logger.getLogger(RedirectorServer.class.getName());

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(port);
            logger.info("Redirecting connections on port " + server.getLocalPort() + " to " + newsite);

            while (true) {
                Socket cs = server.accept();
                handleRequest(cs);
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Server error", e);
        }
    }

    private static void handleRequest(Socket cs) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(cs.getInputStream()));
        PrintWriter out = new PrintWriter(cs.getOutputStream(), true)) {
            String input = reader.readLine();
                logger.info("Request received:"+input);

            String[] pieces = input.split("\\s+");
            String thefile = pieces[1];

                System.out.println(Arrays.toString(pieces));
                System.out.println(thefile);

                if(input.contains("HTTP"))

            {
                sendHttpResponse(out, thefile);
            }else

            {
                logger.warning("Unsupported HTTP request: " + input);
            }
        }catch(IOException e){
            logger.log(Level.SEVERE, "Error handling request", e);
        } finally{
            try {
                cs.close();
            } catch (IOException e) {
                logger.log(Level.SEVERE, "Error closing socket", e);
            }
        }
    }

    private static void sendHttpResponse(PrintWriter out, String thefile) {
        out.write("HTTP/1.1 302 FOUND\r\n");
        Date now = new Date();
        out.write("Date: " + now + "\r\n");
        out.write("Server: Redirector 1.1\r\n");
        out.write("Location: " + newsite + thefile + "\r\n");
        out.write("Content-Type: text/html\r\n");

        out.write("<HTML><HEAD><TITLE>Document Moved</TITLE></HEAD>\r\n");
        out.write("<BODY><H1>Document Moved</H1>\r\n");
        out.write("The document" + thefile + "has been moved to\r\n<A HREF=\"" + newsite + thefile + "\">" + newsite + thefile + "</A>\r\n");
        out.write("</BODY></HTML>");

        out.flush();
    }
}
