import java.util.*;
import java.util.concurrent.*;

class ParkingLot {
    Semaphore semaphore;

    ParkingLot(int count) {
        semaphore = new Semaphore(count);
    }

    void park(int time) throws InterruptedException {
        semaphore.acquire();

        System.out.println("Lock acquired for thread " + Thread.currentThread().getName() + " for time " + time);
        Thread.sleep(time * 1000);

        semaphore.release();
    }
}

public class SemaphoreSolution {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(3);

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                try {
                    parkingLot.park(2);
                } catch (Exception ex) {

                }
            });
            thread.setName("Car " + i);
            thread.start();
        }
    }
}
