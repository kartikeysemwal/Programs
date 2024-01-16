import java.util.*;

public class PrincessesAndPrinces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        HashSet<Integer> set;
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            set = new HashSet<>();
            int left = -1;
            for (int i = 1; i <= n; i++) {
                set.add(i);
            }
            for (int i = 0; i < n; i++) {
                int m = sc.nextInt();
                boolean given = false;
                for (int j = 0; j < m; j++) {
                    int kingdom = sc.nextInt();
                    if (set.contains(kingdom)) {
                        set.remove(kingdom);
                        given = true;
                        j = j + 1;
                        for (; j < m; j++) {
                            sc.nextInt();
                        }
                    }
                }
                if (!given) {
                    left = i + 1;
                }
            }
            if (left != -1) {
                int kingdom = set.iterator().next();
                sb.append("IMPROVE\n").append(left + " " + kingdom).append("\n");
            } else {
                sb.append("OPTIMAL").append("\n");
            }
        }
        System.out.print(sb);
    }
}