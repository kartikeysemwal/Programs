import java.util.*;

public class Knapsack1 {
    static long solve(int weight[], int value[], int N, int W) {
        long ans = Integer.MIN_VALUE;
        long dp[][] = new long[N + 1][W + 1];

        for (int w = 0; w <= W; w++) {
            dp[1][w] = 0;
        }
        dp[1][weight[1]] = value[1];

        for (int i = 2; i <= N; i++) {
            for (int w = 0; w <= W; w++) {
                dp[i][w] = dp[i - 1][w];
                if (weight[i] <= w)
                    dp[i][w] = Math.max(dp[i][w], value[i] + dp[i - 1][w - weight[i]]);
            }
        }
        for (int w = 0; w <= W; w++) {
            ans = Math.max(ans, dp[N][w]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();

        int weight[] = new int[n + 1];
        int value[] = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }

        System.out.println(solve(weight, value, n, w));
    }
}