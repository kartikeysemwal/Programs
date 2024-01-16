import java.util.*;

public class ConstantPalindromeSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            // For no changes
            int mp[] = new int[2 * k + 10];
            for (int i = 0; i < n / 2; i++) {
                int first = i;
                int last = n - i - 1;

                mp[arr[first] + arr[last]]++;
            }
            // For one change
            int pre[] = new int[2 * k + 10];
            for (int i = 0; i < n / 2; i++) {
                int first = i;
                int last = n - i - 1;

                int val = Math.min(arr[first], arr[last]) + 1;
                pre[val] += 1;
                val = Math.max(arr[first], arr[last]) + k;
                pre[val + 1] -= 1;
            }

            for (int i = 1; i < pre.length; i++) {
                pre[i] = pre[i - 1] + pre[i];
            }
            int minChanges = n;
            for (int i = 2; i <= 2 * k; i++) {
                int cnt0 = mp[i];
                int cnt1 = pre[i] - cnt0;
                int cnt2 = (n / 2) - cnt1 - cnt0;

                minChanges = Math.min(minChanges, 0 * cnt0 + 1 * cnt1 + 2 * cnt2);
            }
            System.out.println(minChanges);
        }
    }
}