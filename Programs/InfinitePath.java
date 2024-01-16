import java.util.*;

public class InfinitePath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();

            int p[] = new int[n + 1];
            int c[] = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                p[i] = sc.nextInt();
            }
            for (int i = 1; i <= n; i++) {
                c[i] = sc.nextInt();
            }

            boolean vis[] = new boolean[n + 1];
            HashMap<Integer, ArrayList<Integer>> walk = new HashMap<>();

            for (int i = 1; i <= n; i++) {
                if (vis[i]) {
                    continue;
                }
                vis[i] = true;
                ArrayList<Integer> al = new ArrayList<>();
                al.add(i);
                int cur = i;
                while (p[cur] != i) {
                    cur = p[cur];
                    vis[cur] = true;
                    al.add(cur);
                }
                walk.put(i, al);
            }
            int ans = n;

            for (Map.Entry<Integer, ArrayList<Integer>> entry : walk.entrySet()) {
                ArrayList<Integer> al = entry.getValue();
                int size = al.size();

                for (int i = 1; i * i <= size; i++) {
                    int k = i;
                    if (size % k != 0) {
                        continue;
                    }
                    boolean poss[] = new boolean[k];
                    Arrays.fill(poss, true);
                    for (int j = 0; j < size; j++) {
                        if (c[al.get(j)] != c[al.get(j % k)]) {
                            poss[j % k] = false;
                        }
                    }
                    for (boolean el : poss) {
                        if (el == true) {
                            ans = Math.min(ans, k);
                        }
                    }

                    k = size / k;
                    poss = new boolean[k];
                    Arrays.fill(poss, true);
                    for (int j = 0; j < size; j++) {
                        if (c[al.get(j)] != c[al.get(j % k)]) {
                            poss[j % k] = false;
                        }
                    }
                    for (boolean el : poss) {
                        if (el == true) {
                            ans = Math.min(ans, k);
                        }
                    }
                }
            }
            // System.out.println(ans);
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}