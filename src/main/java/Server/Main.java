package Server;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        int threads = Runtime.getRuntime().availableProcessors() * 2 - 1;
        try {
            Server server = new Server(3000, 50, threads);
            server.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
