package SSL;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SSLClient {
    public static void main(String[] args) {
        String host = "alchemymails.com";
        int port = 443;
        SSLSocket socket = null;
        try {
            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();

            socket = (SSLSocket) factory.createSocket(host, port);
            socket.setSoTimeout(5000);
            socket.startHandshake();

            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            writer.println("GET / HTTP/1.1");
            writer.println("Host: " + host);
            writer.println("Connection: close");
            writer.println();

            String response;
            while ((response = br.readLine()) != null) {
                System.out.println(response);

            }
            writer.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (socket != null) {
                try {
                    socket.close();
                }catch (Exception e) {

                }
            }
        }
    }
}
