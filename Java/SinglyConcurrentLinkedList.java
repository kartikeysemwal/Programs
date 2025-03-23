import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

// there could be other solution
// 1. Head lock and tail lock
// 2. Locks at the node level

class ConcurrentLinkedList {
    static class Node {
        Node next;
        Node prev;
        int val;
    }

    Node head;
    Node tail;

    ReentrantLock headLock;
    ReentrantLock tailLock;

    ConcurrentLinkedList() {
        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.prev = head;

        headLock = new ReentrantLock();
        tailLock = new ReentrantLock();
    }

    void add(int val) {

        boolean onlyTailLock = false;

        if (head.next != tail) {
            onlyTailLock = true;
        }

        tailLock.lock();
        if (!onlyTailLock) {
            headLock.lock();
        }

        Node toAdd = new Node();
        toAdd.val = val;

        toAdd.next = tail;
        toAdd.prev = tail.prev;
        tail.prev = toAdd;
        toAdd.prev.next = toAdd;

        System.out.println("Added " + val);

        if (!onlyTailLock) {
            headLock.unlock();
        }
        tailLock.unlock();
    }

    int remove() {
        if (head.next == tail) {
            return -1;
        }

        boolean onlyHeadLock = false;

        if (tail.prev != head && (tail.prev != null && tail.prev.prev != head)) {
            onlyHeadLock = true;
        }

        headLock.lock();
        if (!onlyHeadLock) {
            tailLock.lock();
        }

        Node rem = head.next;
        head.next = rem.next;
        head.next.prev = head;

        System.out.println("Removed " + rem.val);

        if (!onlyHeadLock) {
            tailLock.unlock();
        }
        headLock.unlock();

        return rem.val;
    }

    void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class SinglyConcurrentLinkedList {
    public static void main(String[] args) {
        ConcurrentLinkedList linkedList = new ConcurrentLinkedList();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                linkedList.add(i);
                try {
                    Thread.sleep(10);
                } catch (Exception ex) {

                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 10; i < 20; i++) {
                linkedList.add(i);
                try {
                    Thread.sleep(100);
                } catch (Exception ex) {

                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (Exception ex) {

        }

        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                linkedList.remove();
            }
        });

        t3.start();
        try {
            t3.join();
        } catch (Exception ex) {

        }

        linkedList.print();
    }
}
