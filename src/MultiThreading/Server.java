package MultiThreading;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public final static int PORT = 9007;

    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(PORT)) {
            while(true) {
                Socket connection = serverSocket.accept();
                Thread task = new ServerThreads(connection);
                task.start();
            }
        }catch (IOException e) {
            System.out.println("Could not start server");
        }
    }
}
