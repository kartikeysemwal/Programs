import java.util.*;

public class FirstProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long testCases = sc.nextLong();
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCases; t++) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long n = sc.nextLong();
            long operations = 0;
            while (true) {
                if (a > n || b > n) {
                    break;
                }
                if (a > b) {
                    b += a;
                } else {
                    a += b;
                }
                operations++;
            }
            // System.out.println(operations);
            sb.append(operations).append("\n");
        }
        System.out.print(sb);
    }
}