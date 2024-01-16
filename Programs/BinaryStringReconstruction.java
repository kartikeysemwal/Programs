import java.util.*;

public class BinaryStringReconstruction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCases; t++) {
            int n0 = sc.nextInt();
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();

            if (n0 > 0 && n1 == 0 && n2 == 0) {
                for (int i = 0; i <= n0; i++) {
                    sb.append("0");
                }
                sb.append("\n");
            } else if (n0 == 0 && n1 == 0 && n2 > 0) {
                for (int i = 0; i <= n2; i++) {
                    sb.append("1");
                }
                sb.append("\n");
            } else {
                for (int i = 0; i < n2; i++) {
                    sb.append("1");
                }
                sb.append("1");
                for (int i = 0; i < n0; i++) {
                    sb.append("0");
                }
                int turn = 0;
                for (int i = 0; i < n1; i++) {
                    sb.append(turn == 0 ? "0" : "1");
                    turn = turn ^ 1;
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}