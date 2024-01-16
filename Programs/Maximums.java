import java.util.*;

public class Maximums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        int b = sc.nextInt();
        long max = b;
        // System.out.print(b + " ");
        sb.append(b + " ");
        for (int i = 0; i < n - 1; i++) {
            b = sc.nextInt();
            long a = b + max;
            // System.out.print(a + " ");
            sb.append(a + " ");
            max = Math.max(max, a);
        }
        System.out.println(sb);
    }
}