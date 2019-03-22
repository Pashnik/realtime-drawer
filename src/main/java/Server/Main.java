package Server;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            Server server = new Server(3000, 50);
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
