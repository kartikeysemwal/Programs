import java.util.*;

public class DivisibleSubarrays {
    public static long solve(int arr[], int n, int beginIndex, int sum) {
        long ans = 0;

        if (beginIndex >= n) {
            if (sum != 0 && sum % n == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        if (sum != 0 && sum % n == 0) {
            ans += 1;
        }

        for (int i = beginIndex; i < n; i++) {
            ans += solve(arr, n, i + 1, sum + arr[beginIndex]);
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            long arr[] = new long[100005];

            int peigenHole[] = new int[100005];

            long ans = 0;
            arr[0] = 0;
            peigenHole[(int) arr[0]]++;
            for (int i = 1; i <= n; i++) {
                int cur = sc.nextInt();
                arr[i] = (n + (cur + arr[i - 1]) % n) % n;

                peigenHole[(int) arr[i]]++;
            }
            for (int i = 0; i < n; i++) {
                int current = peigenHole[i];

                if (current >= 2) {
                    ans += (long) current * (long) (current - 1) / 2;
                }
            }
            System.out.println(ans);
        }
    }
}