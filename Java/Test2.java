class ThreadTest {
    volatile static int counter;

    ThreadTest() {
        counter = 0;
    }

    synchronized void printOdd() {
        while (counter < 10) {
            if (counter % 2 == 1) {
                System.out.println(Thread.currentThread().getName() + " " + counter);
                counter++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (Exception ex) {

                }
            }
        }
    }

    synchronized void printEven() {
        while (counter < 10) {
            if (counter % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + " " + counter);
                counter++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (Exception ex) {

                }
            }
        }
    }
}

public class Test2 {
    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                threadTest.printEven();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                threadTest.printOdd();
            }
        });

        t1.start();
        t2.start();
    }
}
