import java.util.*;

public class GameWithChips {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        for (int i = 0; i < 2 * 2 * k; i++) {
            sc.nextInt();
        }
        int total = (n - 1) + (m - 1) + n * (m - 1) + (n - 1);
        sb.append(total).append("\n");

        for (int i = 0; i < n - 1; i++) {
            sb.append("U");
        }
        for (int i = 0; i < m - 1; i++) {
            sb.append("L");
        }
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 1; j < m; j++) {
                    sb.append("R");
                }
            } else {
                for (int j = 1; j < m; j++) {
                    sb.append("L");
                }
            }
            if (i != n - 1) {
                sb.append("D");
            }
        }
        System.out.print(sb);
    }
}