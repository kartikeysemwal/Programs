import java.util.*;

class StrangeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();
        for (int t = 0; t < testCases; t++) {
            int x = sc.nextInt();
            int k = sc.nextInt();
            int cnt = 0;

            for (int i = 2; i * i <= x; i++) {
                while (x % i == 0) {
                    cnt++;
                    x /= i;
                }
            }

            if (x > 1) {
                cnt++;
            }
            if (cnt >= k) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }

    }
}