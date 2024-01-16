import java.util.*;

public class SleepingSchedule {
    static int n, h, l, r;
    static int arr[];

    public static int solve(int index, int sum) {
        int ans = 0;
        // sum = sum % h;
        if (sum % h >= l && sum % h <= r) {
            ans++;
        }
        // We have to check for every value whether it will give us best result at a[i]
        // or a[i]-1
        if (index + 1 < n) {
            ans += Math.max(solve(index + 1, sum + arr[index + 1] - 1), solve(index + 1, sum + arr[index + 1]));
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        h = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();

        arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        // System.out.println(Math.max(solve(0, arr[0] - 1), solve(0, arr[0])));

        int dp[][] = new int[n + 1][h + 1];

        dp[0][0] = 0;
        for (int i = 1; i < h; i++) {
            dp[0][i] = -1;
        }

        for (int i = 0; i < n; i++) {
            for (int hr = 0; hr < h; hr++) {
                dp[i + 1][hr] = -1;
            }

            for (int hr = 0; hr < h; hr++) {
                if (dp[i][hr] == -1) {
                    continue;
                }
                int h1 = (hr + arr[i + 1] - 1 + h) % h;
                int h2 = (hr + arr[i + 1]) % h;
                dp[i + 1][h1] = Math.max(dp[i + 1][h1], dp[i][hr] + ((l <= h1 && h1 <= r) == true ? 1 : 0));
                dp[i + 1][h2] = Math.max(dp[i + 1][h2], dp[i][hr] + ((l <= h2 && h2 <= r) == true ? 1 : 0));
            }
        }
        int ans = 0;
        for (int i = 0; i < h; i++) {
            if (dp[n][i] != -1) {
                ans = Math.max(ans, dp[n][i]);
            }
        }
        System.out.println(ans);
    }
}