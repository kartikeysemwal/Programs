import java.util.*;

public class SimplePolygonEmbedding2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            double theta = Math.toRadians(180 / 4);
            double delta = Math.toRadians((double) 180 / n);
            double x = 0, min = Double.MAX_VALUE, max = Double.MIN_VALUE;

            for (int i = 0; i < 2 * n; i++) {
                x = x + Math.cos(theta);
                theta = theta - delta;

                min = Math.min(x, min);
                max = Math.max(x, max);
            }
            double ans = max - min;
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}