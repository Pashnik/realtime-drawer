package Client.Core;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Client {

    private final Socket socket;
    private final TaskQueue taskQueue;
    private final InputStream inputStream;

    public Client(String host, int port) throws IOException {
        this.socket = new Socket(host, port);
        this.taskQueue = new TaskQueue();
        this.inputStream = socket.getInputStream();

        new Producer(taskQueue, inputStream);
    }

    public void getMessages() throws InterruptedException {
        while (true) {
            System.out.println(taskQueue.get());
        }
    }


}
