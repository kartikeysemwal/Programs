import java.util.*;

public class BadUglyNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int testCases = sc.nextInt();
        for (int t = 0; t < testCases; t++) {
            int cur = sc.nextInt();
            if (cur == 1) {
                // System.out.println("-1");
                sb.append("-1").append("\n");
            } else {
                // System.out.print("2");
                sb.append("2");
                cur--;
                while (cur-- != 0) {
                    // System.out.print("3");
                    sb.append("3");
                }
                // System.out.println();
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}