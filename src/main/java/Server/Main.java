package Server;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        int threads = Runtime.getRuntime().availableProcessors() * 2 - 1;
        try {
            Server server = new Server(29288, 50, threads);

            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt")));
            String line;
            while ((line = reader.readLine()) != null) {
                server.sendCommand(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}