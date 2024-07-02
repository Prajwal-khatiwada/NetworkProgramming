package multiThreadedPooled;

import java.io.IOException;

public class ClientsPool {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 5; i++) {
            ClientThreadsPool c=new ClientThreadsPool(i);
            c.start();
        }
    }
}
