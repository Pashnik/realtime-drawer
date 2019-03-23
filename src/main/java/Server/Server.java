package Server;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;


public class Server {

    private static final Logger log = Logger.getLogger(Server.class);

    private final ServerSocket serverSocket;
    private final ThreadPool threadPool;
    private final List<Socket> connections;
    private final Cache cache;


    public Server(int port, int backlog, int threads) throws IOException {
        setLogProperties();
        serverSocket = new ServerSocket(port, backlog);
        log.info("server is started");

        threadPool = new ThreadPool(threads);
        connections = Collections.synchronizedList(new ArrayList<>());
        cache = new Cache();

        listen();
    }

    /*
    Listen for new clients and send all commands from cache to new connected client
    */

    private void listen() {
        threadPool.doTask(() -> {
            while (true) {
                Socket acceptSocket = getConnection();
                connections.add(acceptSocket);
                if (!cache.isEmpty()) {
                    List<String> commands = cache.readAll();
                    ServerSender sender = new ServerSender(acceptSocket);
                    for (String command : commands) {
                        sender.send("From cache:" + " " + command);
                    }
                }
            }
        });
    }

    private Socket getConnection() throws IOException {
        Socket acceptSocket = serverSocket.accept();
        log.info("client is connected by socket:" + " " + acceptSocket.toString());
        return acceptSocket;
    }

    /*
    Send command to all clients from connections list
    */

    public void sendCommand(String command) throws IOException {
        Objects.requireNonNull(command);
        synchronized (connections) { // synchronization for Iterator
            for (Socket connection : connections) {
                ServerSender sender = new ServerSender(connection);
                threadPool.doTask(() -> sender.send(command));
            }
        }
        cache.write(command);
    }

    public void stop() throws IOException {
        closeConnections();
        threadPool.closeWorkPool();
        serverSocket.close();
    }

    private void closeConnections() throws IOException {
        synchronized (connections) {
            for (Socket connection : connections) {
                connection.close();
            }
        }
    }

    private void setLogProperties() {
        Properties prop = new Properties();
        InputStream input;
        try {
            input = new FileInputStream("resources/cfg/log4j.properties");
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String pattern = prop.getProperty("log4j.appender.stdout.layout.conversionPattern");
        BasicConfigurator.configure(new ConsoleAppender(new PatternLayout(pattern)));
    }
}
