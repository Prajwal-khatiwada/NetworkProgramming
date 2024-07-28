package SecureSocket;

import javax.imageio.IIOException;
import javax.net.ssl.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.security.KeyStore;
import java.util.Arrays;


public class SecureOrderTracker {
    public final static int PORT = 7009;
    public final static String algorithm = "SSL";


    public static void main(String[] args) {
        try {
            SSLContext context = SSLContext.getInstance(algorithm);

            KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");

            KeyStore ks = KeyStore.getInstance("JKS");

            char[] password = System.console().readPassword();

            ks.load(new FileInputStream("src/SecureSocket/newkeys.keys"), password);
            kmf.init(ks, password);

            context.init(kmf.getKeyManagers(), null, null);
            Arrays.fill(password, '0');

            SSLServerSocketFactory factory = context.getServerSocketFactory();
            SSLServerSocket server = (SSLServerSocket) factory.createServerSocket(PORT);

            String[] supported = server.getSupportedCipherSuites();
            String[] anonCipherSuitesSupported = new String[supported.length];
            int numAnonCipherSuitesSupported = 0;

            for (int i = 0; i < supported.length; i++) {
                if (supported[i].indexOf("_anon_") > 0) {
                    anonCipherSuitesSupported[numAnonCipherSuitesSupported++] = supported[i];
                }
            }

            String[] oldEnabled = server.getSupportedCipherSuites();
            System.out.println(oldEnabled.length);
            String[] newEnabled = new String[
                    oldEnabled.length +
                            numAnonCipherSuitesSupported
                    ];
            ;
            System.arraycopy(
                    oldEnabled, 0, newEnabled, 0, oldEnabled.length
            );
            server.setEnabledCipherSuites(newEnabled);

            while (true) {
                try (Socket theConnection = server.accept()) {
                    InputStream in = theConnection.getInputStream();
                    int c;
                    while ((c = in.read()) != -1) {
                        System.out.write(c);
                    }
                    System.out.println("Hello");
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
