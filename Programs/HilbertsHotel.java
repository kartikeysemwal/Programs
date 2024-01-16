import java.util.*;

public class HilbertsHotel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int testCases = sc.nextInt();
        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            int vis[] = new int[n];

            for (int i = 0; i < n; i++) {
                int cur = sc.nextInt();
                int x = ((cur % n) + n) % n;
                x = (x + i) % n;

                vis[x]++;
            }
            String ans = "YES";
            for (int i = 0; i < n; i++) {
                if (vis[i] > 1) {
                    ans = "NO";
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}