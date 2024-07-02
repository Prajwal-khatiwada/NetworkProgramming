import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class ProcessLog {
    public static void main(String[] args) {
        String file = "logfile.txt";
        try {
            FileReader fin = new FileReader(file);
            BufferedReader bin = new BufferedReader(fin);

            for (String entry = bin.readLine(); entry != null; entry = bin.readLine()) {
                //Separate out the IP Address
                int index = entry.indexOf(' ');
                String ip = entry.substring(0, index);
                String therest = entry.substring(index);

                //Ask DNS for Host name and print
                InetAddress address = InetAddress.getByName(ip);
                System.out.println(address.getHostName() + therest);

            }
            bin.close();
        } catch (UnknownHostException e) {
            System.err.println(e);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        }

    }
}