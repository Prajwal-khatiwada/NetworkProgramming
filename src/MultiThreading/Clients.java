package MultiThreading;

import java.io.IOException;

public class Clients {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 5; i++) {
            ClientThreads c=new ClientThreads(i);
            c.start();
        }
    }
}
