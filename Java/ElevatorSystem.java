import java.util.*;
import java.util.concurrent.*;

class ElevatorRequests {
    Queue<Integer> queue;

    ElevatorRequests() {
        this.queue = new LinkedList<>();
    }

    synchronized void addRequest(int num) {
        queue.add(num);
        notify();
    }

    synchronized int getRequest() throws InterruptedException {
        if (queue.isEmpty()) {
            wait();
        }
        return queue.remove();
    }
}

class Elevator implements Runnable {
    String name;
    int floor;
    ElevatorRequests elevatorRequests;

    Elevator(String name, int floor, ElevatorRequests elevatorRequests) {
        this.name = name;
        this.floor = floor;
        this.elevatorRequests = elevatorRequests;
    }

    public void run() {
        System.out.println("Started elevator " + name);
        while (true) {
            try {
                int rem = elevatorRequests.getRequest();
                System.out.println("Elevator " + name + " is moving to floor " + rem);
                floor = rem;
            } catch (Exception ex) {

            }
        }
    }
}

public class ElevatorSystem {
    public static void main(String[] args) {
        ElevatorRequests elevatorRequests = new ElevatorRequests();

        for (int i = 0; i < 3; i++) {
            Elevator elevator = new Elevator(i + "", 0, elevatorRequests);
            Thread thread = new Thread(elevator);
            thread.start();
        }

        for (int i = 0; i < 10; i++) {
            elevatorRequests.addRequest(i);
        }
    }
}
