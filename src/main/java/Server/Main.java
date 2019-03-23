package Server;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int threads = Runtime.getRuntime().availableProcessors() * 2 - 1;
        try {
            Server server = new Server(29288, 50, threads);
            for (int i = 0; i < 10; i++) {
                server.sendCommand("Command" + " " + i);
            }
            Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < 10; i++) {
                server.sendCommand(scanner.next());
            }
            server.stop();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
