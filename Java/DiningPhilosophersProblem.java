// import java.util.*;
// import java.util.concurrent.*;

// class Philosopher implements Runnable {
// int num;
// Semaphore leftFork;
// Semaphore rightFork;

// Philosopher(int num, Semaphore leftFork, Semaphore rightFork) {
// this.num = num;
// this.leftFork = leftFork;
// this.rightFork = rightFork;
// }

// public synchronized void run() {
// try {
// // think
// Thread.sleep(1000);

// leftFork.acquire();
// System.out.println("Aquired left fork " + num);
// rightFork.acquire();
// System.out.println("Aquired right fork " + num);

// // eat
// Thread.sleep(1000);

// rightFork.release();
// System.out.println("Released right fork " + num);
// leftFork.release();
// System.out.println("Released left fork " + num);
// } catch (Exception ex) {

// }
// }
// }

// public class DiningPhilosophersProblem {
// public static void main(String[] args) {
// int n = 5;

// Semaphore[] semaphores = new Semaphore[n];

// for (int i = 0; i < n; i++) {
// semaphores[i] = new Semaphore(1);
// }

// for (int i = 0; i < n; i++) {
// Philosopher cur = null;
// if (i == n - 1) {
// cur = new Philosopher(i, semaphores[0], semaphores[n - 1]);
// } else {
// cur = new Philosopher(i, semaphores[i], semaphores[i + 1]);
// }

// Thread thread = new Thread(cur);
// thread.start();
// }
// }
// }

// // import java.util.concurrent.Semaphore;
// // import java.util.concurrent.ThreadLocalRandom;

// // public class DiningPhilosophersProblem {
// // // defining the number of philosophers
// // static int philosopher = 5;
// // // initializing an array of philosophers with the number of philosophers
// // static Philosopher philosophers[] = new Philosopher[philosopher];
// // // initializing an array of chosticks with the number of philosophers
// // static Chopstick chopsticks[] = new Chopstick[philosopher];

// // static class Chopstick {
// // // creating a constructor of the Semaphore class that accepts the number
// // permits
// // public Semaphore mutex = new Semaphore(1);

// // // the method grabs the chopstick
// // void grab() {
// // try {
// // // acquires a permit from the semaphore
// // mutex.acquire();
// // } catch (Exception e) {
// // e.printStackTrace(System.out);
// // }
// // }

// // // release the chopstick
// // void release() {
// // // releases an acquire a permit and increases the number of available
// permits
// // by
// // // one
// // mutex.release();
// // }

// // // checks if the chopstick is free or not
// // boolean isFree() {
// // // the method returns the current number of permits available in the
// // semaphore
// // // returns true if available permits is greater than 0, else returns false
// // return mutex.availablePermits() > 0;
// // }
// // } // end of Chopstick class

// // static class Philosopher extends Thread {
// // public int number;
// // // represents left chopstick
// // public Chopstick leftchopstick;
// // // represents right chopstick
// // public Chopstick rightchopstick;

// // // creating a constructor of the Philosopher class
// // Philosopher(int num, Chopstick left, Chopstick right) {
// // number = num;
// // leftchopstick = left;
// // rightchopstick = right;
// // }

// // public void run() {
// // while (true) {
// // // philosopher grabs the chopsticks if both are free
// // leftchopstick.grab();
// // System.out.println("Philosopher " + (number + 1) + " grabs left
// chopstick.");
// // rightchopstick.grab();
// // System.out.println("Philosopher " + (number + 1) + " grabs right
// // chopstick.");
// // // hunger philosopher starts eating
// // eat();
// // // releases left and right chopsticks when philosopher is not hunger
// // leftchopstick.release();
// // System.out.println("Philosopher " + (number + 1) + " releases left
// // chopstick.");
// // rightchopstick.release();
// // System.out.println("Philosopher " + (number + 1) + " releases right
// // chopstick.");
// // } // end of while loop
// // } // end of run() method
// // // the method invokes after grabbing both the chopsticks (left and right)

// // void eat() {
// // try {
// // // determines the pseudorandom number between 0 to 1000 that represents
// the
// // // sleep time in milli seconds
// // int sleepTime = ThreadLocalRandom.current().nextInt(0, 1000);
// // System.out.println("Philosopher " + (number + 1) + " eats for " +
// sleepTime +
// // "ms"); // sleeps the
// // // thread for a
// // // specified time
// // Thread.sleep(sleepTime);
// // } catch (Exception e) {
// // e.printStackTrace(System.out);
// // }
// // }// end of eat() method
// // }

// // public static void main(String args[]) {
// // // loop iterates over chopsticks
// // for (int i = 0; i < philosopher; i++) {
// // chopsticks[i] = new Chopstick();
// // } // end of for loop
// // // loop iterates over philosopher
// // for (int i = 0; i < philosopher; i++) {
// // if (i == philosopher - 1) {
// // philosophers[i] = new Philosopher(i, chopsticks[(i + 1) % philosopher],
// // chopsticks[i]);
// // } else {
// // philosophers[i] = new Philosopher(i, chopsticks[i], chopsticks[(i + 1) %
// // philosopher]);
// // }
// // // begins the execution of the thread
// // philosophers[i].start();
// // } // end of for loop
// // while (true) {
// // try {
// // // thread sleep for 1 sec or 1000ms
// // Thread.sleep(1000);
// // // check for deadlock condition
// // boolean deadlock = true;
// // // for each loop iterates over chopsticks
// // for (Chopstick cs : chopsticks) {
// // // checks if chopstick is free or not
// // if (cs.isFree()) {
// // deadlock = false;
// // break;
// // } // end of if
// // } // end of for loop
// // // deadlock occurs if sleep time is 1000ms it means each philosopher is
// // eating
// // if (deadlock) {
// // Thread.sleep(1000);
// // System.out.println("Everyone Eats");
// // break;
// // } // end of if
// // } catch (Exception e) {
// // e.printStackTrace(System.out);
// // }
// // }
// // System.out.println("Exit The Program!");
// // System.exit(0);
// // }
// // }

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

class Philosopher implements Runnable {
    int num;
    Lock leftFork;
    Lock rightFork;

    Philosopher(int num, Lock leftFork, Lock rightFork) {
        this.num = num;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    public void run() {
        try {
            System.out.println("Philosopher " + num + " going to sleep");

            // first sleep for sometime
            Thread.sleep(1000);

            leftFork.lock();
            System.out.println("Philosopher " + num + " acquired left fork");
            rightFork.lock();
            System.out.println("Philosopher " + num + " acquired left fork");

            System.out.println("Philosopher " + num + " started eating");
            Thread.sleep(2000);

            System.out.println("Philosopher " + num + " released left fork");
            leftFork.unlock();
            System.out.println("Philosopher " + num + " released left fork");
            rightFork.unlock();

        } catch (Exception ex) {
            System.out.println("Exception " + ex.getMessage());
        }
    }
}

public class DiningPhilosophersProblem {
    public static void main(String[] args) {
        Philosopher philosopher[] = new Philosopher[5];
        Lock lock[] = new Lock[5];

        for (int i = 0; i < 5; i++) {
            lock[i] = new ReentrantLock();
        }

        for (int i = 0; i < 5; i++) {
            if (i != 4) {
                philosopher[i] = new Philosopher(i, lock[i], lock[i + 1]);
            } else {
                philosopher[i] = new Philosopher(i, lock[0], lock[4]);
            }

            Thread thread = new Thread(philosopher[i]);
            thread.start();
        }
    }
}