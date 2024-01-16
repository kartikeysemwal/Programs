import java.util.*;

public class MonopoleMagnets {
    static String arr[] = new String[1000];

    static class UnionFind {
        int pr[];
        int sz[];

        UnionFind(int n) {
            pr = new int[n + 1];
            sz = new int[n + 1];

            for (int i = 0; i < n; i++) {
                pr[i] = i;
                sz[i] = 1;
            }
        }

        int root(int i) {
            if (pr[i] == i) {
                return i;
            }
            return pr[i] = root(pr[pr[i]]);
        }

        int un(int i, int j) {
            int u = root(i);
            int v = root(j);

            if (u == v) {
                return 0;
            }
            if (sz[u] < sz[v]) {
                int temp = u;
                u = v;
                v = temp;
            }
            pr[v] = u;
            sz[u] += sz[v];
            return 1;
        }
    }

    static int code(int n, int m, int i, int j) {
        return m * i + j;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
        }
        Set<Integer> rw = new HashSet<>();
        Set<Integer> cl = new HashSet<>();
        ArrayList<Integer> aw_row = new ArrayList<>();
        ArrayList<Integer> aw_col = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            aw_row.add(0);
        }
        for (int i = 0; i < m; i++) {
            aw_col.add(0);
        }

        for (int i = 0; i < n; i++) {
            boolean found_black = false;
            for (int j = 0; j < m; j++) {
                if (arr[i].charAt(j) == '#') {
                    rw.add(i);
                    cl.add(j);
                    found_black = true;
                }
            }
            if (!found_black) {
                aw_row.set(i, 1);
            }
        }
        for (int j = 0; j < m; j++) {
            boolean found_black = false;
            for (int i = 0; i < n; i++) {
                if (arr[i].charAt(j) == '#') {
                    found_black = true;
                    break;
                }
            }
            if (!found_black) {
                aw_col.set(j, 1);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (aw_row.get(i) == 1 && aw_col.get(j) == 1) {
                    rw.add(i);
                    cl.add(j);
                }
            }
        }
        if (rw.size() < n || cl.size() < m) {
            System.out.println("-1");
            return;
        }
        int can = 1;
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> v = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                if (arr[i].charAt(j) == '#') {
                    v.add(j);
                }
            }
            for (int k = 1; k < v.size(); k++) {
                if (v.get(k) > v.get(k - 1) + 1) {
                    can = 0;
                    break;
                }
            }
        }
        for (int j = 0; j < m; j++) {
            ArrayList<Integer> v = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (arr[i].charAt(j) == '#') {
                    v.add(i);
                }
            }
            for (int k = 1; k < v.size(); k++) {
                if (v.get(k) > v.get(k - 1) + 1) {
                    can = 0;
                    break;
                }
            }
        }
        if (can == 0) {
            System.out.println("-1");
            return;
        }

        UnionFind dsu = new UnionFind(n * m);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i].charAt(j) == '.')
                    continue;
                if (i + 1 < n && arr[i + 1].charAt(j) == '#')
                    dsu.un(code(n, m, i, j), code(n, m, i + 1, j));
                if (i - 1 >= 0 && arr[i - 1].charAt(j) == '#')
                    dsu.un(code(n, m, i, j), code(n, m, i - 1, j));
                if (j + 1 < m && arr[i].charAt(j + 1) == '#')
                    dsu.un(code(n, m, i, j), code(n, m, i, j + 1));
                if (j - 1 >= 0 && arr[i].charAt(j - 1) == '#')
                    dsu.un(code(n, m, i, j), code(n, m, i, j - 1));
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i].charAt(j) == '.')
                    continue;
                int num = code(n, m, i, j);

                if (dsu.root(num) == num) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}