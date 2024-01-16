// import java.util.*;

// class A extends Thread {
// public void run() {
// for (int i = 1; i <= 5; i++) {
// System.out.println("Hi");
// try {
// Thread.sleep(1000);
// } catch (Exception e) {

// }
// }
// }
// }

// class B extends Thread {
// public void run() {
// for (int i = 1; i <= 5; i++) {
// System.out.println("Hello");
// try {
// Thread.sleep(1000);
// } catch (Exception e) {

// }
// }
// }
// }

// public class ThreadClass {
// public static void main(String[] args) {
// Scanner sc = new Scanner(System.in);

// A obj1 = new A();
// B obj2 = new B();

// obj1.start();
// try {
// Thread.sleep(10);
// } catch (Exception e) {

// }
// obj2.start();

// }
// }