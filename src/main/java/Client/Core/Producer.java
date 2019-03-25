package Client.Core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class Producer extends Thread {

    private final TaskQueue taskQueue;
    private final BufferedReader reader;

    public Producer(TaskQueue taskQueue, InputStream stream) {
        this.taskQueue = taskQueue;
        this.reader = new BufferedReader(new InputStreamReader(stream));
        start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                String command = reader.readLine();
                taskQueue.add(command);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
