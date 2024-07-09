package ServerWithLog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost",9000);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Write message to the server: ");
            String msgForServer = stdin.readLine();
            out.println(msgForServer);
            System.out.println("you: " + msgForServer);

            String response = input.readLine();
            System.out.println("Server: " + response);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
