package Server;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class ThreadPool {

    private final ExecutorService executorService;

    public ThreadPool(int threads) {
        executorService = Executors.newFixedThreadPool(threads);
    }


    public void doTask(Semaphore semaphore, Worker worker) {
        executorService.execute(() -> {
            worker.process();
            semaphore.release();
        });
    }

    public void closeWorkPool() {
        executorService.shutdown();
    }


}
