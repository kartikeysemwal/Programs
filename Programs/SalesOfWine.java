import java.util.*;

public class SalesOfWine {
    static int dp[][] = new int[100][100];

    public static int solve(int arr[], int begin, int end, int year) {
        if (begin == end) {
            return arr[begin] * year;
        }
        if (dp[begin][end] != 0) {
            return dp[begin][end];
        }
        int ans = 0;
        ans = Math.max(arr[begin] * year + solve(arr, begin + 1, end, year + 1),
                arr[end] * year + solve(arr, begin, end - 1, year + 1));
        return dp[begin][end] = ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solve(arr, 0, n - 1, 1));
    }
}