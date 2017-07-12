

import java.io.*;
import java.net.*;
class EuroThread extends Thread {
    Socket c;
    BufferedReader in;
    PrintWriter out;

    EuroThread(Socket sock) {
        System.out.println("Neuer Client wird bearbeitet.");
       c = sock;
       try {
          in  = new BufferedReader(new InputStreamReader(c.getInputStream()));
           out = new PrintWriter(c.getOutputStream(), true);
        }
        catch (IOException e) { }
    }

    public void run() {
        try {

            String zeile;
            double wert;
            boolean toEuroDesired, nochmal;

            nochmal = true;


            while (nochmal) {
                out.println("(DM oder EUR)?");
                zeile = in.readLine();
                if (zeile == null) break;
                toEuroDesired = zeile.toUpperCase().startsWith("DM");

                out.println("Welchen Wert wollen Sie umrechnen?");
                zeile = in.readLine();
                if (zeile == null) break;
                wert = Double.parseDouble(zeile);

                if (toEuroDesired) {
                    wert = wert*0.51;
                    out.println("Wert in EUR: " + wert);
                }
                else {
                    wert = wert*1.96;
                    out.println("Wert in DM: " + wert);
                }

                out.println();
                out.println("noch eine Umrechnung?");
                zeile = in.readLine();
                if (zeile == null) break;
                nochmal = zeile.startsWith("j") || zeile.startsWith("J");
            }
        }
        catch (IOException ign) { }
    }


}

