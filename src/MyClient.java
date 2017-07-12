
import java.net.*;
import java.io.*;
public class MyClient {

    static void zeigeWasKommt(BufferedReader sin) throws IOException {
        String str = null;
        try {
            while ((str = sin.readLine()) != null)
                System.out.println(str);
        }
        catch (SocketTimeoutException sto) {
        }
    }

    static void zeigePrompt() {
        System.out.print("> ");
        System.out.flush();
    }

    public static void main(String[] args) {
        try {
            String serverName = "127.0.0.1";
            int port = 4445;
            System.out.println("Beenden mit QUIT");
            Socket c = new Socket(serverName, port);
            c.setSoTimeout(500);
            BufferedReader vomServer = new BufferedReader(
                    new InputStreamReader(
                            c.getInputStream()));
            PrintWriter zumServer = new PrintWriter(
                    c.getOutputStream(), true);
            BufferedReader vonTastatur = new BufferedReader(
                    new InputStreamReader(
                            System.in));
            String zeile;

            do {
                zeigeWasKommt(vomServer);
                zeigePrompt();
                zeile = vonTastatur.readLine();
                zumServer.println(zeile);
            } while(!zeile.equalsIgnoreCase("quit"));

            c.close();
        }
        catch (ArrayIndexOutOfBoundsException ae) {
            System.out.println(" Port Nummer ");
        }
        catch (UnknownHostException ux) {
            System.out.println("Kein DNS");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
