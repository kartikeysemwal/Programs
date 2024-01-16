import java.util.*;

public class MaximumSumOnEvenPositions {

    static long helper(int arr[], int start) {
        long max = 0;
        long sum = 0;
        int n = arr.length;
        if (start == 0)
            for (int i = start; i + 1 < n; i += 2) {
                sum = sum + (arr[i + 1] - arr[i]);
                if (sum > max) {
                    max = sum;
                }
                if (sum < 0) {
                    sum = 0;
                }
            }
        else if (start == 1)
            for (int i = start; i + 1 < n; i += 2) {
                sum = sum + (arr[i] - arr[i + 1]);
                if (sum > max) {
                    max = sum;
                }
                if (sum < 0) {
                    sum = 0;
                }
            }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            long ans = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                if (i % 2 == 0) {
                    ans += arr[i];
                }
            }
            if (n == 1) {
                sb.append(ans).append("\n");
                continue;
            }
            ans += Math.max(helper(arr, 0), helper(arr, 1));
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}