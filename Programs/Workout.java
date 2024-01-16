import java.util.*;

public class Workout {
    static int arr[];
    static int n, k;

    public static boolean check(int d) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans += (arr[i] - 1) / d;
        }
        if (ans <= k) {
            return true;
        }
        return false;
    }

    public static int solve(int low, int high) {
        while (low < high) {
            int mid = (low + high) / 2;
            if (check(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int t = 0; t < testCases; t++) {
            n = sc.nextInt();
            k = sc.nextInt();

            arr = new int[n - 1];
            int last = sc.nextInt();
            int current = -1;
            for (int i = 1; i < n; i++) {
                current = sc.nextInt();
                arr[i - 1] = current - last;
                last = current;
            }
            System.out.println("Case #" + (t + 1) + ": " + solve(1, 1000000000));
        }
    }
}
