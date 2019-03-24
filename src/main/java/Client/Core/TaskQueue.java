package Client.Core;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class TaskQueue {

    private final BlockingDeque<String> taskQueue;

    public TaskQueue() {
        taskQueue = new LinkedBlockingDeque<>();
    }

    public void add(String command) throws InterruptedException {
        taskQueue.put(command);
    }

    public String get() throws InterruptedException {
        return taskQueue.take();
    }
}
