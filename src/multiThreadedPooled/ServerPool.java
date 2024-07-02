package multiThreadedPooled;

import MultiThreading.ServerThreads;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerPool {
    public final static int PORT = 8008;
    static ExecutorService pool= Executors.newFixedThreadPool(50);

    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(PORT)) {
            while(true) {
                Socket connection = serverSocket.accept();
                System.out.println("Client connected: "+connection);

                ServerThreadsPool serverThreads =new ServerThreadsPool(connection);
                pool.submit(serverThreads);
            }
        }catch (IOException e) {
            System.out.println("Could not start server");
        }
    }
}
