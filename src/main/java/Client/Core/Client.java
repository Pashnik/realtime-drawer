package Client.Core;

import Client.Graphics.MainFrame;

import java.io.IOException;

import java.net.Socket;

public class Client {

    private final MainFrame mainFrame;
    private final TaskQueue taskQueue;
    private final String host;
    private final int port;


    public Client(String host, int port) {
        this.host = host;
        this.port = port;
        this.taskQueue = new TaskQueue();

        this.mainFrame = new MainFrame();
    }

    public void start() throws IOException, InterruptedException {
        Socket socket = new Socket(host, port);
        new Producer(taskQueue, socket.getInputStream());

        new Consumer(taskQueue, mainFrame).consume();
    }

}
