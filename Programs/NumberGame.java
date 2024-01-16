import java.util.*;

public class NumberGame {
    static Set<Integer> power = new HashSet<>();

    static void powerOfTwo() {
        int p = 2;
        while (p <= 1000000005) {
            power.add(p);
            p = p * 2;
        }
    }

    // 1000000005
    // 536870912
    static boolean checkPrime(int n) {
        for (int i = 2; i < Math.min(50000, n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        powerOfTwo();

        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            int turn = 0;
            while (n > 1) {
                turn = turn ^ 1;
                if (n % 2 == 1) {
                    n = 1;
                } else if (n % 2 == 0) {
                    if (power.contains(n)) {
                        n = n - 1;
                        continue;
                    }
                    if (checkPrime(n / 2)) {
                        n = 2;
                        continue;
                    }
                    n = 4;
                    continue;
                }
            }
            if (turn == 0) {
                sb.append("FastestFinger").append("\n");
            } else {
                sb.append("Ashishgup").append("\n");
            }
        }
        System.out.print(sb);
    }
}