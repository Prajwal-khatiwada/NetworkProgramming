package UDPClientServer;

import javax.imageio.IIOException;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) {
        DatagramSocket clientSocket = null;

        try {
            byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[1024];

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter message to send to the server: ");
            String inFromUser = sc.nextLine();

            clientSocket = new DatagramSocket(0);
            clientSocket.setSoTimeout(10000);

            InetAddress IPAddress = InetAddress.getByName("127.0.0.1");

            sendData = inFromUser.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9999);
            clientSocket.send(sendPacket);

            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);

            String modifiedSentence = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("FROM SERVER " + modifiedSentence);

            InetAddress IPAddress2 = sendPacket.getAddress();
            System.out.println("IP Address: "+IPAddress2 +" Port: "+sendPacket.getPort());
        } catch (SocketException e) {
            System.err.println("SOCKET EXCEPTION: "+e.getMessage());
        }catch (UnknownHostException e){
            System.err.println("HOST EXCEPTION: "+e.getMessage());
        }catch (IOException e){
            System.err.println("IO EXCEPTION: "+e.getMessage());
        }catch (SecurityException e){
            System.err.println("SECURITY EXCEPTION: "+e.getMessage());
        }catch (IllegalArgumentException e){
            System.err.println("ILLEGAL EXCEPTION: "+e.getMessage());
        }catch (NullPointerException e){
            System.err.println("NULL EXCEPTION: "+e.getMessage());
        }catch (Exception e){
            System.err.println("EXCEPTION: "+e.getMessage());
        }finally {
            if (clientSocket != null && !clientSocket.isClosed()) {
                clientSocket.close();
            }
        }

    }
}
