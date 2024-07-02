package MultiThreading;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class ServerThreads extends Thread {
private Socket connection;

ServerThreads(Socket connection) {
    this.connection = connection;
    System.out.println("Server thread started at port: "+this.connection.getPort());
}

@Override
    public void run() {
    try{
        System.out.println("Processing for client with port: "+this.connection.getPort());
        PrintWriter out = new PrintWriter(connection.getOutputStream(), true);
        Date now = new Date();
        out.println(now.toString());
    }catch (Exception ex){
        System.out.println(ex.getMessage());
    }finally{
        try {
            connection.close();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}
}
