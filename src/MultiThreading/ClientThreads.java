package MultiThreading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientThreads extends Thread {
    private int no;
    public ClientThreads(int i) {
        this.no = i;
    }

    @Override
    public void run() {
        Socket server;
        try {
            server = new Socket("localhost", 9007);
            System.out.println("Connection started from port: " + server.getLocalPort());

            InputStreamReader in = new InputStreamReader(server.getInputStream());
            BufferedReader input = new BufferedReader(in);
            String response =input.readLine();
            System.out.println("Message received from port: "+ server.getLocalPort()+ ",message: " + response);
            server.close();

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}
