import java.util.*;

public class MinimumStepsToOne {
    static int dp[] = new int[10005];

    public static void solve() {
        dp[1] = 0;
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;
        int z = Integer.MAX_VALUE;
        for (int i = 2; i < dp.length; i++) {
            x = y = z = Integer.MAX_VALUE;

            if (i % 2 == 0) {
                x = dp[i / 2];
            }
            if (i % 3 == 0) {
                y = dp[i / 3];
            }
            if (i - 1 >= 1) {
                z = dp[i - 1];
            }
            dp[i] = Math.min(x, Math.min(y, z)) + 1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        solve();
        int testCases = sc.nextInt();
        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();

            System.out.println(dp[n]);
        }
    }
}