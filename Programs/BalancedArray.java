import java.util.*;

public class BalancedArray {
    static int even[] = new int[200005];
    static int odd[] = new int[200005];

    static void preCompute() {
        for (int i = 2, j = 0; j < 100010; i += 6, j += 2) {
            even[j] = i;
            even[j + 1] = i + 2;

            odd[j] = i - 1;
            odd[j + 1] = i + 2 + 1;
        }
    }

    public static void main(String[] args) {
        preCompute();
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            int a = n / 2;
            if (a % 2 == 1) {
                sb.append("NO").append("\n");
            } else {
                sb.append("YES").append("\n");
                for (int i = 0; i < a; i++) {
                    sb.append(even[i] + " ");
                }
                for (int i = 0; i < a; i++) {
                    sb.append(odd[i] + " ");
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}