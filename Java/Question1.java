// There is single Bathroom to be used in a Voting agency for both Democrats(D) and Republicans(R) * This single Bathroom which can accomodate 3 people at most * each person takes f(N) secs to do his thing. f(N) is a function of the person's name and returns varying number * CONDITION: At any given time, the bathroom cannot have a mixed set of people i.e. * CONDITION: Bathroom can have at most 3 people * these combinations aren't allowed (2D, 1R) or (1D,1R) * These are allowed (), (3D), (2D), (1R) i.e. pure Republicans or Pure Democrats * While the bathroom is occupied people are to wait in a queue * What is the most optimal system where you would manage people in this queue, so that * the most eligible person instants gets to use the bathroom whenever its has room, based on above conditions

import java.util.*;
import java.util.concurrent.*;

class SolutionRD {
    enum STATE {
        REPUBLICAN,
        DEMOCRAT,
        EMPTY
    }

    enum TURN {
        DEMOCRAT,
        REPUBLICAN
    }

    private int democrats;
    private int republicans;
    STATE bathroomState;
    TURN turnState;

    SolutionRD() {
        democrats = 0;
        republicans = 0;
        bathroomState = STATE.EMPTY;
        turnState = TURN.DEMOCRAT;
    }

    synchronized void entryRepublican(int time) throws Exception {
        while (bathroomState.equals(STATE.DEMOCRAT) || republicans >= 3
                || (turnState.equals(TURN.DEMOCRAT) && democrats > 0)) {
            wait();
        }

        if (bathroomState.equals(STATE.EMPTY)) {
            bathroomState = STATE.REPUBLICAN;
            turnState = TURN.REPUBLICAN;
        }

        republicans++;
        processR(time);
    }

    void processR(int time) throws Exception {
        Thread thread = new Thread(() -> {
            System.out.println("R is doing its thing for time " + time);
            try {
                Thread.sleep(time * 1000);
                exitRepublican();
            } catch (Exception ex) {

            }
        });
        thread.start();
    }

    synchronized void exitRepublican() {
        republicans--;
        if (republicans == 0) {
            bathroomState = STATE.EMPTY;
            turnState = TURN.DEMOCRAT;
            notifyAll();
        }
    }

    synchronized void entryDemocrat(int time) throws Exception {
        while (bathroomState.equals(STATE.REPUBLICAN) || democrats >= 3
                || (turnState.equals(TURN.REPUBLICAN) && republicans > 0)) {
            wait();
        }

        if (bathroomState.equals(STATE.EMPTY)) {
            bathroomState = STATE.DEMOCRAT;
            turnState = TURN.DEMOCRAT;
        }

        democrats++;
        processD(time);
    }

    void processD(int time) throws Exception {
        Thread thread = new Thread(() -> {
            System.out.println("Democrat in for time " + time);
            try {
                Thread.sleep(time * 1000);
                exitDemocrat();
            } catch (Exception ex) {

            }
        });
        thread.start();
    }

    synchronized void exitDemocrat() throws Exception {
        democrats--;
        if (democrats == 0) {
            bathroomState = STATE.EMPTY;
            turnState = TURN.REPUBLICAN;
            notifyAll();
        }
    }
}

public class Question1 {

    public static void main(String[] args) {
        List<Future<?>> list = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        SolutionRD solution = new SolutionRD();

        for (int i = 0; i < 5; i++) {
            var cur = executorService.submit(() -> {
                try {
                    solution.entryRepublican(1);
                } catch (Exception ex) {

                }
            });
            list.add(cur);
        }

        for (int i = 0; i < 5; i++) {
            var cur = executorService.submit(() -> {
                try {
                    solution.entryDemocrat(1);
                } catch (Exception ex) {

                }
            });
            list.add(cur);
        }

        for (var future : list) {
            try {
                future.get();
            } catch (Exception ex) {

            }
        }

        executorService.shutdown();
    }
}
