// Implement a barrier that:
// - Waits for N threads to arrive
// - Releases all threads once N is reached
// Follow up: How would you reset it?

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

class Barrier {
    List<Thread> list;
    int capacity;

    Barrier(int capacity) {
        list = new ArrayList<>();
        this.capacity = capacity;
    }

    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    Lock readLock = lock.readLock();
    Lock writeLock = lock.writeLock();

    synchronized void add(Thread thread) {
        list.add(thread);

        if (list.size() >= capacity) {

        }
    }

    void process() {

    }
}

public class BarrierSolution {
    public static void main(String[] args) {

    }
}
