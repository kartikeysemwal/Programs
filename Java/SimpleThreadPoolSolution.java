// import java.util.*;
// import java.util.concurrent.*;

// class Worker extends Thread {
// int num;
// SimpleThreadPool simpleThreadPool;

// Worker(int num, SimpleThreadPool simpleThreadPool) {
// this.num = num;
// this.simpleThreadPool = simpleThreadPool;
// }

// public void run() {
// System.out.println("Worker started " + num);
// while (true) {
// Runnable task = simpleThreadPool.getTask();
// System.out.println("Worked " + num + " picked the task");
// task.run();
// }
// }
// }

// class SimpleThreadPool {
// List<Worker> workers;
// Queue<Runnable> tasks;

// SimpleThreadPool() {
// workers = new ArrayList<>();
// addWorkers();

// tasks = new LinkedList<>();
// }

// private void addWorkers() {
// for (int i = 0; i < 10; i++) {
// Worker worker = new Worker(i, this);
// workers.add(worker);
// worker.start();
// }
// }

// synchronized void addTask(Runnable task) {
// tasks.add(task);
// notify();
// }

// synchronized Runnable getTask() {
// while (tasks.isEmpty()) {
// try {
// wait();
// } catch (Exception ex) {

// }
// }
// return tasks.remove();
// }

// synchronized void shutdown() {
// for (var worker : workers) {
// worker.interrupt();
// }
// }
// }

// public class SimpleThreadPoolSolution {
// public static void main(String[] args) {
// SimpleThreadPool simpleThreadPool = new SimpleThreadPool();

// for (int i = 0; i < 20; i++) {
// Runnable task = () -> {
// try {
// Thread.sleep(100);
// } catch (Exception ex) {

// }
// };

// simpleThreadPool.addTask(task);
// }
// }
// }

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

class Worker extends Thread {
    int num;
    SimpleThreadPool simpleThreadPool;

    Worker(int num, SimpleThreadPool threadPool) {
        this.num = num;
        this.simpleThreadPool = threadPool;
    }

    public void run() {
        while (true) {
            Runnable task = simpleThreadPool.getTask();
            System.out.println("Worker " + num + " executing task");
            task.run();
        }
    }
}

class SimpleThreadPool {
    List<Worker> workers;
    Queue<Runnable> queue;

    SimpleThreadPool() {
        workers = new ArrayList<>();
        queue = new LinkedList<>();

        for (int i = 0; i < 2; i++) {
            workers.add(new Worker(i, this));
        }

        for (var worker : workers) {
            worker.start();
        }
    }

    synchronized void addTask(Runnable task) {
        queue.add(task);
        notify();
    }

    synchronized Runnable getTask() {
        while (queue.isEmpty()) {
            try {
                wait();
            } catch (Exception ex) {
                System.out.println("Exception " + ex.getMessage());
            }
        }

        return queue.remove();
    }

    synchronized void interrupt() {
        for (var worker : workers) {
            worker.interrupt();
        }
    }
}

public class SimpleThreadPoolSolution {
    public static void main(String[] args) {
        SimpleThreadPool simpleThreadPool = new SimpleThreadPool();

        for (int i = 0; i < 10; i++) {
            simpleThreadPool.addTask(() -> {
                System.out.println("This is task");
                try {
                    Thread.sleep(2000);
                } catch (Exception ex) {
                    System.out.println("Exception " + ex.getMessage());
                }
            });
        }
    }
}