import java.util.*;

public class ZeroRemainderArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            HashMap<Integer, Integer> set = new HashMap<>();
            int max = 0;
            int val = 0;

            for (int i = 0; i < n; i++) {
                int cur = sc.nextInt();
                int mod = (int) Math.ceil((double) cur / k);
                mod = k * mod - cur;
                if (mod == 0) {
                    continue;
                }
                int occur = 0;
                if (set.containsKey(mod)) {
                    occur = set.get(mod);
                }
                occur++;
                set.put(mod, occur);
                if (occur >= max) {
                    if ((occur == max && mod > val) || (occur > max)) {
                        max = occur;
                        val = mod;
                    }
                }
            }
            if (val == 0) {
                sb.append(0).append("\n");
                continue;
            }
            long ans = val + (long) k * (max - 1) + 1;
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}