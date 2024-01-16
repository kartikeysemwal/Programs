import java.util.*;

public class WeightsDistributing {
    static int INF = Integer.MAX_VALUE;
    static ArrayList<ArrayList<Integer>> map;

    public static void bfs(int src, ArrayList<Integer> al, int n) {
        for (int i = 0; i < n; i++) {
            al.add(INF);
        }
        al.set(src, 0);
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int child : map.get(node)) {
                if (al.get(child) == INF) {
                    al.set(child, al.get(node) + 1);
                    q.add(child);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            a--;
            b--;
            c--;
            int p[] = new int[m];
            for (int i = 0; i < m; i++) {
                p[i] = sc.nextInt();
            }
            Arrays.sort(p);
            long pre[] = new long[m + 1];
            for (int i = 0; i < m; i++) {
                pre[i + 1] = p[i] + pre[i];
            }
            map = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                map.add(new ArrayList<>());
            }
            for (int i = 0; i < m; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                x--;
                y--;
                map.get(x).add(y);
                map.get(y).add(x);
            }
            ArrayList<Integer> da = new ArrayList<>();
            ArrayList<Integer> db = new ArrayList<>();
            ArrayList<Integer> dc = new ArrayList<>();
            bfs(a, da, n);
            bfs(b, db, n);
            bfs(c, dc, n);

            long ans = Long.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (da.get(i) + db.get(i) + dc.get(i) <= m) {
                    ans = Math.min(ans, pre[db.get(i)] + pre[da.get(i) + db.get(i) + dc.get(i)]);
                }
            }
            System.out.println(ans);
        }
    }
}