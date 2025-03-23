// Implement a custom read-write lock where:
// - Multiple readers can read simultaneously
// - Only one writer can write
// - Writers have priority over readers

// import java.util.*;
// import java.util.concurrent.*;

// class ReadWriteLock {
// int readers;
// int writers;
// int writersWaiting;

// ReadWriteLock() {
// this.readers = 0;
// this.writers = 0;
// this.writersWaiting = 0;
// }

// synchronized void getReadLock() {
// while (writers > 0 || writersWaiting > 0) {
// try {
// wait();
// } catch (Exception ex) {

// }
// }

// readers++;
// }

// synchronized void releaseReadLock() {
// readers--;
// notifyAll();
// }

// synchronized void getWriteLock() {
// writersWaiting++;

// while (writers > 0 || readers > 0) {
// try {
// wait();
// } catch (Exception ex) {

// }
// }

// writersWaiting--;
// writers++;
// }

// synchronized void releaseWriteLock() {
// writers--;
// notifyAll();
// }
// }

// public class ReadWriteLockSolution {
// public static void main(String[] args) {
// ReadWriteLock readWriteLock = new ReadWriteLock();

// Runnable reader = () -> {
// for (int i = 0; i < 10; i++) {
// readWriteLock.getReadLock();
// System.out.println(Thread.currentThread().getName() + " is reading");
// try {
// Thread.sleep(100);
// } catch (Exception e) {
// }
// readWriteLock.releaseReadLock();
// }
// };

// Runnable writer = () -> {
// for (int i = 0; i < 10; i++) {
// readWriteLock.getWriteLock();
// System.out.println(Thread.currentThread().getName() + " is writing");
// try {
// Thread.sleep(100);
// } catch (Exception e) {
// }
// readWriteLock.releaseWriteLock();
// }
// };

// for (int i = 0; i < 2; i++) {

// Thread thread = new Thread(reader, "ThreadRead" + i);
// thread.start();
// }

// for (int i = 0; i < 2; i++) {

// Thread thread = new Thread(writer, "ThreadWrite" + i);
// thread.start();
// }
// }
// }

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

class ReadWriteLock {
    int readers;
    int writers;
    int writersWaiting;
    ReentrantLock lock;
    Condition condition;

    ReadWriteLock() {
        readers = 0;
        writers = 0;
        writersWaiting = 0;
        lock = new ReentrantLock();
        condition = lock.newCondition();
    }

    void getReadLock() {
        lock.lock();
        while (writers > 0 || writersWaiting > 0) {
            try {
                condition.await();
            } catch (Exception ex) {

            }
        }

        readers++;
        System.out.println("Read lock granted");
        lock.unlock();
    }

    void releaseReadLock() {
        lock.lock();
        readers--;
        condition.signalAll();
        System.out.println("Released read lock");
        lock.unlock();
    }

    void getWriteLock() {
        lock.lock();
        writersWaiting++;
        while (readers > 0 || writers > 0) {
            try {
                condition.await();
            } catch (Exception ex) {

            }
        }

        writersWaiting--;
        writers++;
        System.out.println("Write lock granted");
        lock.unlock();
    }

    void releaseWriteLock() {
        lock.lock();
        writers--;
        condition.signalAll();
        System.out.println("Released write lock");
        lock.unlock();
    }
}

public class ReadWriteLockSolution {
    public static void main(String[] args) {
        ReadWriteLock readWriteLock = new ReadWriteLock();

        Runnable taskRead = () -> {
            readWriteLock.getReadLock();
            try {
                Thread.sleep(1000);
            } catch (Exception ex) {
                System.out.println("Exception " + ex.getMessage());
            }
            readWriteLock.releaseReadLock();
        };

        Runnable taskWrite = () -> {
            readWriteLock.getWriteLock();
            try {
                Thread.sleep(2000);
            } catch (Exception ex) {
                System.out.println("Exception " + ex.getMessage());
            }
            readWriteLock.releaseWriteLock();
        };

        for (int i = 0; i < 10; i++) {
            Thread thread1 = new Thread(taskRead);
            Thread thread2 = new Thread(taskWrite);

            thread1.start();
            thread2.start();
        }
    }
}