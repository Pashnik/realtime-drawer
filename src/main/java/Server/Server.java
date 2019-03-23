package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

    private final ServerSocket serverSocket;
    private final ThreadPool threadPool;
    private final List<Socket> connections;
    private final Cache cache;


    public Server(int port, int backlog, int threads) throws IOException {
        serverSocket = new ServerSocket(port, backlog);
        threadPool = new ThreadPool(threads);
        connections = new ArrayList<>();
        cache = new Cache();
    }

    /*
    Send all commands from cache to new connected client
    */

    public void start() {
        threadPool.doTask(() -> {
            while (true) {
                Socket acceptSocket = serverSocket.accept();
                if (!cache.isEmpty()) {
                    List<String> commands = cache.readAll();
                    ServerSender sender = new ServerSender(acceptSocket);
                    for (String command : commands) {
                        sender.send(command);
                    }
                }
                connections.add(acceptSocket);
            }
        });
    }

    /*
    Send command to all clients from connections list
     */

    public void sendCommand(String command) {
        for (Socket connection : connections) {
            threadPool.doTask(() -> {

                ServerSender sender = new ServerSender(connection);
                sender.send(command);

            });
        }
        cache.write(command);
    }
}
