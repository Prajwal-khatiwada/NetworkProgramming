package UDPClientServer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
    public static void main(String[] args) throws IOException {
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];

        DatagramSocket ServerSocket = new DatagramSocket(9999);

        while(true){
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            ServerSocket.receive(receivePacket);

            String sentence = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Client Says: "+sentence);

            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            sendData = sentence.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            ServerSocket.send(sendPacket);


        }
    }
}
