import java.util.*;
import java.util.concurrent.*;

class SharedBuffer {
    Queue<Integer> queue;
    int capacity;

    SharedBuffer(int capacity) {
        this.capacity = capacity;
        queue = new LinkedList<>();
    }

    public synchronized void produce(int toAdd) throws InterruptedException {
        while (queue.size() == capacity) {
            wait();
        }

        System.out.println("Produced " + toAdd);
        queue.add(toAdd);
        notifyAll();
    }

    public synchronized void consume() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }

        System.out.println("Consumed " + queue.remove());
        notifyAll();
    }
}

class Producer implements Runnable {
    SharedBuffer sharedBuffer;

    Producer(SharedBuffer producer) {
        this.sharedBuffer = producer;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                sharedBuffer.produce(i);
                Thread.sleep(100);

            } catch (Exception ex) {

            }
        }
    }
}

class Consumer implements Runnable {
    SharedBuffer sharedBuffer;

    Consumer(SharedBuffer sharedBuffer) {
        this.sharedBuffer = sharedBuffer;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                sharedBuffer.consume();
                Thread.sleep(100);

            } catch (Exception ex) {

            }
        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) throws InterruptedException {
        SharedBuffer sharedBuffer = new SharedBuffer(2);

        Thread prod1 = new Thread(new Producer(sharedBuffer));
        Thread consume1 = new Thread(new Consumer(sharedBuffer));

        prod1.start();
        consume1.start();
    }
}
