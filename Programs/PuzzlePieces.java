import java.util.*;

public class PuzzlePieces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            if (n == 1 || m == 1) {
                // System.out.println("YES");
                sb.append("YES").append("\n");
            } else if (n == 2 && m == 2) {
                // System.out.println("YES");
                sb.append("YES").append("\n");
            } else {
                // System.out.println("NO");
                sb.append("NO").append("\n");
            }
        }
        System.out.print(sb);
    }
}