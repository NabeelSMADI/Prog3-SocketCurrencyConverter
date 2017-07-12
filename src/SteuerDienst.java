import java.io.*;
class SteuerDienst extends Thread {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String eingabe;
    public void run() {
        try {
           do {
                System.out.println("Server beenden durch Eingabe von SHUTDOWN!");
            } while (!(eingabe = in.readLine()).toLowerCase().startsWith("shutdown"));
            EuroServer.serverAktiv = false;
            System.out.println("Der Server wird nun nach Abarbeitung des");
            System.out.println("naechsten Clients automatisch beendet.");
        }
        catch (IOException e) { }
    }
}

