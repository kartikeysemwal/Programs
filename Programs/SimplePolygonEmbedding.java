import java.util.*;

public class SimplePolygonEmbedding {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int testCases = sc.nextInt();
        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            double ans = 0;
            double theta = Math.toRadians(180 / (2.0 * n));
            ans = 1.0 / Math.tan(theta);
            // System.out.println(ans);
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}