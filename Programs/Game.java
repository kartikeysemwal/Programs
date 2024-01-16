import java.util.*;

public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int testCases = sc.nextInt();
        sc.nextLine();
        for (int t = 0; t < testCases; t++) {
            String str = sc.nextLine();
            char s[] = str.toCharArray();
            int c0 = 0;
            int c1 = 0;
            int n = s.length;
            for (int i = 0; i < n; i++) {
                char cur = s[i];
                if (cur == '0') {
                    c0++;
                } else {
                    c1++;
                }
            }
            if (c0 == 0 || c1 == 0) {
                sb.append("NET").append("\n");
                continue;
            }
            int min = Math.min(c0, c1);
            if (min % 2 != 0) {
                sb.append("DA").append("\n");
            } else {
                sb.append("NET").append("\n");
            }
        }
        System.out.print(sb);
    }
}