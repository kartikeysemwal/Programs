import java.util.*;

public class WalkOnMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        // int x = (int) Math.pow(2, 17);
        // System.out.println("2 3");
        // System.out.println((x ^ k) + " " + x + " 0");
        // System.out.println(k + " " + (x ^ k) + " " + k);

        int x = (int) Math.pow(2, 18) - 1;
        int y = (int) Math.pow(2, 17);
        System.out.println("3 3");
        System.out.println(x + " " + x + " " + y);
        System.out.println(x + " " + k + " " + x);
        System.out.println(y + " " + x + " " + k);
    }
}