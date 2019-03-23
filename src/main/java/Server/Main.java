package Server;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        int threads = Runtime.getRuntime().availableProcessors() * 2 - 1;
        try {
            Server server = new Server(29288, 50, threads);
            server.start();
            for (int i = 0; i < 10; i++) {
                server.sendCommand("Command" + " " + i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
