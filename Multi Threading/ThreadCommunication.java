class Q extends Thread {
    int num;
    boolean valueSet = false;
    int readerCount = 0;
    int writerCount = 0;

    Q() {
        num = 0;
    }

    synchronized void put(int num) {
        writerCount = writerCount + 1;
        while (valueSet) {
            try {
                wait();
            } catch (Exception e) {

            }
        }
        System.out.println("Put : " + num);
        this.num = num;
        writerCount = writerCount - 1;

        if (writerCount == 0) {
            valueSet = true;
            notifyAll();
        }

    }

    synchronized void get(String name) {
        readerCount = readerCount + 1;
        while (!valueSet) {
            try {
                wait();
            } catch (Exception e) {

            }
        }
        System.out.println("Value of num : " + num + " by thread " + name);
        readerCount = readerCount - 1;

        if (readerCount == 0) {
            valueSet = false;
            notifyAll();
        }

    }
}

class Producer extends Thread {
    Q q;

    Producer(Q q) {
        this.q = q;
        Thread t = new Thread(this, "Producer");
        t.start();
    }

    public void run() {
        int i = 0;
        while (true) {
            q.put(i++);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
        }
    }
}

class Consumer extends Thread {
    Q q;

    Consumer(Q q) {
        this.q = q;
    }

    public void run() {
        while (true) {
            q.get(this.getName());
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
        }
    }
}

public class ThreadCommunication {
    public static void main(String[] args) {
        Q q = new Q();

        Consumer c1 = new Consumer(q);
        Consumer c2 = new Consumer(q);

        c1.setName("Consumer 1");
        c2.setName("Consumer 2");

        c1.start();
        c2.start();

        new Producer(q);
        new Producer(q);
    }
}
