import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

class BoundedBlockingQueue {
    int capacity;
    Queue<Integer> queue;

    BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
        queue = new LinkedList<>();
    }

    synchronized void enqueue(int num) {
        while (queue.size() > capacity) {
            try {
                wait();
            } catch (Exception ex) {

            }
        }

        System.out.println("Added " + num);
        queue.add(num);
        notifyAll();
    }

    synchronized int dequeue() {
        while (queue.isEmpty()) {
            try {
                wait();
            } catch (Exception ex) {

            }
        }

        int rem = queue.remove();
        notifyAll();

        System.out.println("Removed " + rem);
        return rem;
    }
}

class Producer implements Runnable {
    BoundedBlockingQueue boundedBlockingQueue;

    Producer(BoundedBlockingQueue boundedBlockingQueue) {
        this.boundedBlockingQueue = boundedBlockingQueue;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            boundedBlockingQueue.enqueue(i);
            try {
                Thread.sleep(10);
            } catch (Exception ex) {

            }
        }
    }
}

class Consumer implements Runnable {
    BoundedBlockingQueue boundedBlockingQueue;

    Consumer(BoundedBlockingQueue boundedBlockingQueue) {
        this.boundedBlockingQueue = boundedBlockingQueue;
    }

    public void run() {
        for (int i = 100; i < 200; i++) {
            boundedBlockingQueue.dequeue();
            try {
                Thread.sleep(1000);
            } catch (Exception ex) {

            }
        }
    }
}

public class BoundedBlockingQueueSolution {
    public static void main(String[] args) {
        BoundedBlockingQueue boundedBlockingQueue = new BoundedBlockingQueue(5);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Producer producer = new Producer(boundedBlockingQueue);
        Thread thread = new Thread(producer);
        executorService.submit(thread);

        for (int i = 0; i < 10; i++) {
            Consumer consumer = new Consumer(boundedBlockingQueue);
            Thread thread2 = new Thread(consumer);
            executorService.submit(thread2);
        }
    }
}
