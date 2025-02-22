import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Multithreading extends Thread {
    private int threadNum;

    Multithreading(int threadNum) {
        this.threadNum = threadNum;
    }

    public void run() {
        for (int i = 0; i < 2; i++) {
            System.out.println(threadNum + " " + i);

            if (threadNum == 0) {
                throw new RuntimeException();
            }

            try {
                Thread.sleep(1000);
            } catch (Exception ex) {

            }
        }
    }
}

class MultithreadingUsingRunnable implements Runnable {
    private int threadNum;

    MultithreadingUsingRunnable(int threadNum) {
        this.threadNum = threadNum;
    }

    public void run() {
        for (int i = 0; i < 2; i++) {
            System.out.println(threadNum + " " + i);

            if (threadNum == 0) {
                throw new RuntimeException();
            }

            try {
                Thread.sleep(1000);
            } catch (Exception ex) {

            }
        }
    }
}

public class Test {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // for (int i = 0; i < 5; i++) {
        // Multithreading multithreading = new Multithreading(i);
        // multithreading.start();
        // }

        // for (int i = 0; i < 5; i++) {
        // MultithreadingUsingRunnable r1 = new MultithreadingUsingRunnable(i);
        // Thread t1 = new Thread(r1);
        // t1.start();
        // }

        var executor = Executors.newSingleThreadExecutor();
        Callable<Integer> task = () -> 10 + 20;
        Future<Integer> future = executor.submit(task);
        System.out.println(future.get());
        executor.shutdown();

        CompletableFuture.runAsync(() -> System.out.println("Here we are in completable future"));
    }
}
