package Server;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        if (args.length != 2) System.exit(-1);

        int threads = Runtime.getRuntime().availableProcessors() * 2 - 1;

        try {
            Server server = new Server(29288, 50, threads, args[1]);
            BufferedReader reader = new BufferedReader(new InputStreamReader
                    (new FileInputStream(args[0])));

            String line;
            while ((line = reader.readLine()) != null) {
                server.sendCommand(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}