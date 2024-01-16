import java.util.*;

public class PermutationPartition {
    static int modulo = 998244353;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        long sum = 0;
        // sum = n * (n + 1) / 2 - (n - k) * (n - k + 1) / 2;
        // System.out.print(sum + " ");
        int lastIndex = -1;
        int greaterThan = (n - k);
        long ans = 1;

        for (int i = 0; i < n; i++) {
            int cur = sc.nextInt();
            if (cur > greaterThan) {
                if (lastIndex != -1) {
                    ans = (ans * (i - lastIndex) % modulo) % modulo;
                }
                lastIndex = i;
                sum += cur;
            }
        }
        System.out.println(sum + " " + ans);
    }
}