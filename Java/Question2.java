import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

class Question {
    static HashMap<Integer, ArrayList<Integer>> account = new HashMap<>();
    static int counter = 0;
    static boolean stop = false;
    static ReentrantLock lock = new ReentrantLock();

    static class Class1 implements Runnable {
        public void run() {
            while (!stop) {
                lock.lock();
                try {
                    Thread.sleep(1000);
                } catch (Exception ex) {
                    System.out.println("Exception " + ex.getMessage());
                }

                // Random random = new Random();
                // int num = random.nextInt(100);
                int num = 1;

                if (!account.containsKey(num)) {
                    account.put(num, new ArrayList<>());
                }

                account.get(num).add(counter);
                System.out.println("Added " + counter);
                counter++;
                lock.unlock();
            }
        }
    }

    static class Class2 implements Runnable {
        public void run() {
            while (!stop) {
                lock.lock();
                try {
                    Thread.sleep(1000);
                } catch (Exception ex) {
                    System.out.println("Exception " + ex.getMessage());
                }

                // Random random = new Random();
                // int num = random.nextInt(100);
                int num = 1;

                if (!account.containsKey(num)) {
                    account.put(num, new ArrayList<>());
                }

                account.get(num).add(counter);
                System.out.println("Added " + counter);
                counter++;
                lock.unlock();
            }
        }
    }

    static class Class3 implements Runnable {
        public void run() {
            while (!stop) {
                lock.lock();
                try {
                    Thread.sleep(1000);
                } catch (Exception ex) {
                    System.out.println("Exception " + ex.getMessage());
                }

                // Random random = new Random();
                // int num = random.nextInt(100);
                int num = 1;

                if (!account.containsKey(num)) {
                    account.put(num, new ArrayList<>());
                }

                account.get(num).add(counter);
                System.out.println("Added " + counter);
                counter++;
                lock.unlock();
            }
        }
    }

    static class Class4 implements Runnable {
        public void run() {
            try {
                Thread.sleep(10000);
                Question.stop = false;
            } catch (Exception ex) {

            }
        }
    }
}

public class Question2 {
    public static void main(String[] args) {
        Question.Class1 class1 = new Question.Class1();
        Question.Class2 class2 = new Question.Class2();
        Question.Class3 class3 = new Question.Class3();
        Question.Class4 class4 = new Question.Class4();

        Thread thread1 = new Thread(class1);
        Thread thread2 = new Thread(class2);
        Thread thread3 = new Thread(class3);
        Thread thread4 = new Thread(class4);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
