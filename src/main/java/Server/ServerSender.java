package Server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ServerSender {

    private final Socket connection;
    private final BufferedWriter writer;

    public ServerSender(Socket connection) throws IOException {
        this.connection = connection;
        this.writer = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
    }

    public void send(String message) throws IOException {
        writer.write(message + "\n");
        writer.flush();
    }

    public void close() throws IOException {
        writer.close();
    }
}
