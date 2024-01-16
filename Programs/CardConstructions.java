import java.util.*;

public class CardConstructions {
    static int n = 100005;
    static long pre[] = new long[n];

    public static int upperBound(long result[], long key) {
        int ans = -1;
        int s = 0, e = n - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (result[mid] == key) {
                s = mid + 1;
            } else if (result[mid] > key) {
                e = mid - 1;
                ans = mid;
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }

    static void preCompute() {
        pre[1] = 2;
        for (int i = 2; i < n; i++) {
            pre[i] = pre[i - 1] + 3 * i - 1;
        }
    }

    public static void main(String[] args) {
        preCompute();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int testCases = sc.nextInt();
        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            int ans = 0;
            while (n > 1) {
                int i = upperBound(pre, n);
                i--;
                n -= pre[i];
                ans++;
            }
            // System.out.println(ans);
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}