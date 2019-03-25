package Client.Core;

import java.io.IOException;

import java.net.Socket;

public class Client {

    private final TaskQueue taskQueue;
    private final String host;
    private final int port;


    public Client(String host, int port) {
        this.host = host;
        this.port = port;
        this.taskQueue = new TaskQueue();
    }

    public void start() throws IOException {
        Socket socket = new Socket(host, port);
        new Producer(taskQueue, socket.getInputStream());
    }
}
