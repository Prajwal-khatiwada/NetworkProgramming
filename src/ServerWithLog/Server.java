package ServerWithLog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    public static Logger infoLog = Logger.getLogger("requests");
    public static Logger errorLog = Logger.getLogger("errors");

    public static void main(String[] args) {
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(20000);
        } catch (IOException e) {
            errorLog.log(Level.SEVERE, "Could not start server");
        }
        infoLog.info("Waiting for connection");

        try {
            Socket cs;
            cs = ss.accept();
            infoLog.info("Connected To: " + "'" + cs.getRemoteSocketAddress());

            InputStreamReader in = new InputStreamReader(cs.getInputStream());
            BufferedReader input = new BufferedReader(in);
            String message = input.readLine();
            infoLog.info("Client Says: " + message);

            PrintWriter out = new PrintWriter(cs.getOutputStream(), true);
            out.println("You said: " + "'" + message + "'");

            ss.close();
        } catch (IOException ex) {
            errorLog.log(Level.SEVERE, "Could not accept connection", ex);
        } catch (Exception e) {
            errorLog.log(Level.SEVERE, "Something went wrong" + e.getMessage(), e);
        }

    }

}
