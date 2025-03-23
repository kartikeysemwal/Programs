// import java.util.*;
// import java.util.concurrent.*;

// class CustomSemaphore {
// int premit;

// CustomSemaphore() {
// this.premit = 1;
// }

// synchronized void acquire() {
// while (this.premit == 0) {
// try {
// System.out.println("Already acquired, waiting");
// wait();
// } catch (Exception ex) {

// }
// }

// System.out.println("Acquired");
// this.premit = 0;
// }

// synchronized void release() {
// System.out.println("Releasing");
// this.premit = 1;
// notify();
// }
// }

// // in the order of getting acquire request
// class FairnessSemaphore {

// int permit;
// Queue<Thread> queue;

// FairnessSemaphore() {
// permit = 1;
// queue = new LinkedList<>();
// }

// synchronized void acquire() {
// Thread thread = Thread.currentThread();
// queue.add(thread);

// while (permit == 0 || queue.peek() != thread) {
// try {
// wait();
// } catch (Exception ex) {

// }
// }

// queue.remove();
// permit = 0;
// }

// synchronized void release() {
// this.permit = 1;
// notifyAll();
// }
// }

// public class CustomSemaphoreSolution {
// public static void main(String args[]) {
// // CustomSemaphore semaphore = new CustomSemaphore();
// // Semaphore semaphore = new Semaphore(1);
// FairnessSemaphore semaphore = new FairnessSemaphore();

// Runnable task = () -> {
// try {
// semaphore.acquire();
// System.out.println("Doing task");
// Thread.sleep(1000);
// } catch (Exception ex) {

// }
// semaphore.release();
// };

// for (int i = 0; i < 6; i++) {
// Thread thread = new Thread(task);
// thread.start();
// }
// }
// }

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.*;

class CustomSemaphore {
    int permit;

    CustomSemaphore(int permit) {
        this.permit = permit;
    }

    synchronized void acquire() {
        while (permit <= 0) {
            try {
                wait();
            } catch (Exception ex) {

            }
        }

        permit--;
    }

    synchronized void release() {
        permit++;
        notify();
    }
}

class FairnessSemaphore {
    int permit;
    Queue<Thread> queue;
    ReentrantLock lock;
    Condition condition;

    FairnessSemaphore(int permit) {
        this.permit = permit;
        queue = new LinkedList<>();
        lock = new ReentrantLock();
        condition = lock.newCondition();
    }

    void acquire() {
        lock.lock();

        Thread thread = Thread.currentThread();
        queue.add(thread);

        while (permit <= 0 || queue.peek() != thread) {
            try {
                condition.await();
            } catch (Exception ex) {

            }
        }

        queue.remove();

        permit--;
        lock.unlock();
    }

    void release() {
        lock.lock();

        permit++;
        condition.signal();

        lock.unlock();
    }
}

class FairnessSemaphore2 {
    int permit;
    Queue<Thread> queue;

    FairnessSemaphore2(int permit) {
        this.permit = permit;
        queue = new LinkedList<>();
    }

    synchronized void acquire() {
        Thread thread = Thread.currentThread();
        queue.add(thread);

        while (permit <= 0 || queue.peek() != thread) {
            try {
                wait();
            } catch (Exception ex) {

            }
        }

        queue.remove();
        permit--;
    }

    synchronized void release() {
        permit++;
        notifyAll();
    }
}

public class CustomSemaphoreSolution {
    public static void main(String[] args) {
        // CustomSemaphore semaphore = new CustomSemaphore(2);
        FairnessSemaphore semaphore = new FairnessSemaphore(2);

        Runnable task = () -> {
            for (int i = 0; i < 10; i++) {
                semaphore.acquire();
                System.out.println("Acquired lock");
                try {
                    Thread.sleep(1000);
                } catch (Exception ex) {

                }
                semaphore.release();
            }
        };

        Thread thread1 = new Thread(task);
        thread1.start();

        Thread thread2 = new Thread(task);
        thread2.start();

        Thread thread3 = new Thread(task);
        thread3.start();

        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.incrementAndGet();
        atomicInteger.decrementAndGet();
    }
}