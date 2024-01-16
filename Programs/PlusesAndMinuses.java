import java.util.*;

public class PlusesAndMinuses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int testCases = sc.nextInt();
        sc.nextLine();
        for (int t = 0; t < testCases; t++) {
            String str = sc.nextLine();
            char s[] = str.toCharArray();
            List<Integer> al = new ArrayList<>();
            int n = s.length;
            for (int i = 0; i < n; i++) {
                char cur = s[i];
                if (i == 0) {
                    if (cur == '-')
                        al.add(-1);
                    else
                        al.add(1);
                    continue;
                }
                if (cur == '-') {
                    if (cur == s[i - 1]) {
                        al.add(al.remove(al.size() - 1) - 1);
                    } else {
                        al.add(-1);
                    }
                } else {
                    if (cur == s[i - 1]) {
                        al.add(al.remove(al.size() - 1) + 1);
                    } else {
                        al.add(1);
                    }
                }
            }
            long res = 0;
            int cur = 0;
            int prev = 0;
            for (int i = 0; i < al.size(); i++) {
                int pc = cur;
                cur = cur + al.get(i);
                if (cur < 0) {
                    res += Math.abs(pc) + 1;
                    int a = prev + Math.abs(al.get(i));
                    int b = prev + Math.abs(pc) + 1;
                    if (Math.abs(cur) > 1)
                        res += (long) a * (a + 1) / 2 - (long) b * (b + 1) / 2 + a;
                    else {
                        res += a;
                    }
                    cur = 0;
                } else {
                    res += Math.abs(al.get(i));
                }
                prev += Math.abs(al.get(i));
            }
            sb.append(res).append("\n");
        }
        System.out.print(sb);
    }
}