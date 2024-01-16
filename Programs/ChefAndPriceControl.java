import java.util.*;

public class ChefAndPriceControl {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            long sum = 0;
            for (int i = 0; i < n; i++) {
                int cur = sc.nextInt();
                if (cur > k) {
                    sum += cur - k;
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }
}