import java.util.*;

public class TernaryString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCases; t++) {
            String str = sc.nextLine();
            char s[] = str.toCharArray();
            int length = s.length;
            int ans = length + 1;
            int l = 0;
            int cnt[] = new int[4];
            for (int r = 0; r < length; r++) {
                int cur = s[r] - '0';
                cnt[cur]++;

                while (cnt[s[l] - '0'] > 1) {
                    cnt[s[l] - '0']--;
                    l++;
                }
                if (cnt[1] >= 1 && cnt[2] >= 1 && cnt[3] >= 1) {
                    ans = Math.min(ans, r - l + 1);
                }
            }
            if (ans == length + 1) {
                sb.append(0).append("\n");
                continue;
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}