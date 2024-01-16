import java.util.*;

public class SumOfOddIntegers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < testCases; t++) {
            long n = sc.nextLong();
            long k = sc.nextLong();

            if ((n < Math.pow(k, 2)) || (n % 2 != k % 2)) {
                // System.out.println("NO");
                sb.append("NO").append("\n");
            } else {
                // System.out.println("YES");
                sb.append("YES").append("\n");
            }
        }
        System.out.print(sb);
    }
}