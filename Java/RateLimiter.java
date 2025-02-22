import java.util.*;
import java.util.concurrent.*;

class RateLimit {
    Queue<Long> queue;
    long timeWindowMillis;
    int maxAllowed;

    RateLimit() {
        queue = new LinkedList<>();
        timeWindowMillis = 1000;
        maxAllowed = 5;
    }

    synchronized boolean addReq() {
        var current = System.currentTimeMillis();

        while (!queue.isEmpty() && queue.peek() < current - timeWindowMillis) {
            queue.remove();
        }

        if (queue.size() < maxAllowed) {
            queue.add(current);
            return true;
        }

        return false;
    }
}

public class RateLimiter {
    public static void main(String[] args) {
        RateLimit rateLimit = new RateLimit();

        Runnable task = () -> {
            for (int i = 0; i < 100; i++) {
                if (rateLimit.addReq()) {
                    System.out.println("Req is granted");

                    try {
                        Thread.sleep(400);
                    } catch (Exception ex) {

                    }
                } else {
                    System.out.println("Req is rejected");
                }
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();
    }
}
