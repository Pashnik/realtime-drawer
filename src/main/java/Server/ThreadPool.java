package Server;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

    private final ExecutorService executorService;

    public ThreadPool(int threads) {
        executorService = Executors.newFixedThreadPool(threads);
    }


    public void doTask(Worker worker) {
        executorService.execute(() -> {
            try {
                worker.process();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void closeWorkPool() {
        executorService.shutdown();
    }

}
