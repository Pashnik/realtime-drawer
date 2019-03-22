package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

    private final ServerSocket serverSocket;
    private final ThreadPool threadPool;
    private final List<Socket> connections;


    public Server(int port, int backlog) throws IOException {
        int threads = Runtime.getRuntime().availableProcessors() * 2;
        serverSocket = new ServerSocket(port, backlog);
        threadPool = new ThreadPool(threads);
        connections = new ArrayList<>();
    }


    public void start() throws IOException {
        while (true) {
            Socket acceptSocket = serverSocket.accept();
            connections.add(acceptSocket);
            threadPool.doTask(() -> {
                while (true) {
                    try {
                        BufferedReader reader = new BufferedReader(new InputStreamReader(acceptSocket.getInputStream()));
                        System.out.println(reader.readLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                /*
                Send all commands from cache to this specified client
                 */

            });
        }
    }


    public void sendCommand(String command) {

            /*
            Send command to all clients from connections list
             */

        for (Socket connection : connections) {
            threadPool.doTask(() -> {

            });
        }
    }
}
