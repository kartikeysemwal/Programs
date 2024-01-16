import java.util.*;

class Frog2 {
    public static long solve(int arr[], int n, int k) {
        long ans[] = new long[n + 1];

        ans[1] = 0;
        ans[2] = Math.abs(arr[1] - arr[2]);

        for (int i = 3; i <= n; i++) {
            ans[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= k && (i - j) >= 1; j++) {
                ans[i] = Math.min(ans[i], Math.abs(arr[i] - arr[i - j]) + ans[i - j]);
            }
            // ans[i] = Math.min(Math.abs(arr[i] - arr[i - 1]) + ans[i - 1], Math.abs(arr[i]
            // - arr[i - 2]) + ans[i - 2]);
        }
        return ans[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int arr[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solve(arr, n, k));
    }
}