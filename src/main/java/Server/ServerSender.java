package Server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.List;

public class ServerSender {

    private final BufferedWriter writer;
    private final Socket connection;
    private final List<Socket> connections;

    public ServerSender(Socket connection, List<Socket> connections) throws IOException {
        this.connection = connection;
        this.writer = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
        this.connections = connections;
    }

    public void send(String message) {
        try {
            writer.write(message + "\n");
            writer.flush();
        } catch (IOException e) { // I don’t know how to find out if the connection is torn
            connections.remove(connection);
        }
    }
}
