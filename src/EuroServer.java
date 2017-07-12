

import java.io.*;
import java.net.*;
class EuroServer {
    static boolean serverAktiv = true;
    public static void main(String[] args) {
            int port = 4445;
            try {
                new SteuerDienst().start();
               ServerSocket server = new ServerSocket(port);
                System.out.println("Der Server laeuft.");
                while (serverAktiv) {
                     new EuroThread(server.accept()).start();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Der Server ist beendet.");
        }

    }

