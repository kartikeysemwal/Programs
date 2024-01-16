import java.util.*;

public class CountTheBlocks {
    static int mod = 998244353;

    static long pwmd(long x, long y) {
        long res = 1;
        x = x % mod;
        if (x == 0)
            return 0;

        while (y > 0) {
            if ((y & 1) == 1)
                res = (res * x) % mod;
            y = y >> 1;
            x = (x * x) % mod;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            long ans = -1;
            if (i == n) {
                ans = 10;
            } else if (i == n - 1) {
                ans = 2 * 9 * 10;
            }

            else {
                // Prefix or suffix
                int rem = (n - i - 1);
                ans = (2 * 10 * 9 * pwmd(10, rem)) % mod;

                // In the middle
                int rest = (n - i - 2);
                ans += ((n - i - 1) * 10 * 9 * 9 * pwmd(10, rest)) % mod;
            }
            System.out.print(ans % mod + " ");
        }
    }
}