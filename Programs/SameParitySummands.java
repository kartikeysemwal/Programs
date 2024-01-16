import java.util.*;

public class SameParitySummands {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            // Check for odd
            if ((n - (k - 1)) % 2 == 1 && (n - (k - 1)) > 0) {
                sb.append("YES").append("\n");
                for (int i = 0; i < k - 1; i++) {
                    sb.append("1 ");
                }
                sb.append(n - (k - 1)).append("\n");
            } else if ((n - (k - 1) * 2) % 2 == 0 && (n - (k - 1) * 2) > 0) {
                sb.append("YES").append("\n");
                for (int i = 0; i < k - 1; i++) {
                    sb.append("2 ");
                }
                sb.append(n - (k - 1) * 2).append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.print(sb);
    }
}