import java.util.*;

// class A implements Runnable {
//     public void run() {
//         for (int i = 1; i <= 5; i++) {
//             System.out.println("Hi");
//             try {
//                 Thread.sleep(1000);

//                 wait();
//                 notify();

//             } catch (Exception e) {

//             }
//         }
//     }
// }

// class B implements Runnable {
//     public void run() {
//         for (int i = 1; i <= 5; i++) {
//             System.out.println("Hello");
//             try {
//                 Thread.sleep(1000);
//             } catch (Exception e) {

//             }
//         }
//     }
// }

public class RunnableInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Thread a = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Hi");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {

                }
            }
        });

        Thread b = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Hello");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {

                }
            }
        });

        Runnable obj3 = new Runnable() {
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    System.out.println("Hi");
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {

                    }
                }
            }
        };

        a.start();
        try {
            Thread.sleep(10);
        } catch (Exception e) {

        }
        b.start();

    }
}