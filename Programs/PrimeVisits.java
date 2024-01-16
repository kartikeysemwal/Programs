import java.util.*;

public class PrimeVisits {
    static boolean prime[] = new boolean[1000005];

    public static void sieveOfEratosthenes() {
        int n = 1000000;
        Arrays.fill(prime, true);

        prime[0] = false;
        prime[1] = false;

        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * p; i <= n; i = i + p) {
                    prime[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        sieveOfEratosthenes();

        for (int t = 0; t < testCases; t++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            int count = 0;
            for (int i = a; i <= b; i++) {
                if (prime[i]) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}