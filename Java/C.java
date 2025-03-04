import java.util.*;

class PrintNumbers {
    static int counter = 1;

    int limit;

    PrintNumbers(int limit) {
        this.limit = limit;
    }

    public synchronized void printEven() {
        while (counter <= limit) {
            if (counter % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + " " + counter);
                counter++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (Exception ex) {
                    System.out.println("Exception " + ex.getMessage());
                }
            }
        }
    }

    public synchronized void printOdd() {
        while (counter <= limit) {
            if (counter % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + " " + counter);
                counter++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (Exception ex) {
                    System.out.println("Exception " + ex.getMessage());
                }
            }
        }
    }
}

public class C {
    public static void main(String[] args) {
        PrintNumbers printNumbers = new PrintNumbers(10);

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                printNumbers.printEven();
            }
        });
        t1.setName("PrintEven");

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                printNumbers.printOdd();
            }
        });
        t2.setName("PrintOdd");

        t1.start();
        t2.start();
    }
}