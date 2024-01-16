import java.util.*;

public class HeightOfAllSame {
    static int modulo = 998244353;

    static long pwmd(long a, long n) {
        if (n == 0) {
            return 1;
        }
        long pt = pwmd(a, n / 2);
        pt *= pt;
        pt %= modulo;
        if (n % 2 != 0) {
            pt *= a;
            pt %= modulo;
        }
        return pt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int l = sc.nextInt();
        int r = sc.nextInt();

        long t = (long) r - l + 1;
        long e = r / 2 - (l - 1) / 2;
        long o = t - e;

        long x = (long) n * m;

        if (x % 2 != 0) {
            System.out.println(pwmd(t, x));
        } else {
            long sub = pwmd(e + o, x) - pwmd(Math.abs(e - o), x);
            sub += modulo;
            sub %= modulo;
            sub = (sub * pwmd(2, modulo - 2)) % modulo;
            long total = pwmd(t, x);
            long ans = (total - sub + modulo) % modulo;
            System.out.println(ans);
        }

    }
}