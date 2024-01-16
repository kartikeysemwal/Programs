import java.util.*;

public class MaximumWhiteSubtree {
    static int arr[] = new int[200005];
    static ArrayList<Integer> adj[] = new ArrayList[200005];
    static int dp1[] = new int[200005];
    static int dp2[] = new int[200005];

    public static void dfs1(int node, int parent) {
        dp1[node] = arr[node] == 1 ? 1 : -1;

        for (int nd : adj[node]) {
            if (nd == parent) {
                continue;
            }
            dfs1(nd, node);
            dp1[node] += Math.max(0, dp1[nd]);
        }
    }

    public static void dfs2(int node, int parent) {
        dp2[node] = dp1[node];
        if (parent != 0) {
            int val = dp2[parent] - Math.max(0, dp1[node]);
            dp2[node] += Math.max(0, val);
        }
        for (int nd : adj[node]) {
            if (nd == parent) {
                continue;
            }
            dfs2(nd, node);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (adj[a] == null) {
                adj[a] = new ArrayList<>();
                adj[a].add(b);
            } else {
                adj[a].add(b);
            }
            if (adj[b] == null) {
                adj[b] = new ArrayList<>();
                adj[b].add(a);
            } else {
                adj[b].add(a);
            }

        }

        dfs1(1, 0);
        dfs2(1, 0);

        for (int i = 1; i <= n; i++) {
            System.out.print(dp2[i] + " ");
        }
        System.out.println();
    }
}