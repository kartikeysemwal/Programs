import java.util.*;

public class PairOfTopics {
    public static long lowerBound(long result[], int n, long key) {
        long ans = -1;
        int s = 0, e = n - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (result[mid] == key) {
                e = mid - 1;
                ans = mid;
            } else if (result[mid] > key) {
                e = mid - 1;
                ans = mid;
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }

    public static long upperBound(long result[], int n, long key) {
        long ans = -1;
        int s = 0, e = n - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (result[mid] == key) {
                s = mid + 1;
                ans = mid;
            } else if (result[mid] > key) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long teacher[] = new long[n];
        long result[] = new long[n];

        for (int i = 0; i < n; i++) {
            teacher[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            result[i] = teacher[i] - sc.nextInt();
        }
        long ans = 0;
        Arrays.sort(result);

        for (int i = 0; i < result.length; i++) {
            long current = result[i];
            if (current <= 0) {
                continue;
            }
            long find = 1 - current;
            long index = lowerBound(result, n, find);
            ans += (i - index);
        }
        System.out.println(ans);
    }
}