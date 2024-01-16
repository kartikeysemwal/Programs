import java.util.*;

public class KthNotDivisible {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int pos = -1;
            if (k % (n - 1) == 0) {
                pos = k / (n - 1);
            } else {
                pos = (k + n - 1) / (n - 1);
            }
            int lastNotDivisible = n * pos - 1;
            int lastNotDivisiblePos = pos * (n - 1);

            int back = lastNotDivisiblePos - k;
            // System.out.println(lastNotDivisible - back);
            sb.append(lastNotDivisible - back).append("\n");
        }
        System.out.print(sb);
    }
}