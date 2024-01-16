
// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Topological {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov + 1; i++)
                list.add(i, new ArrayList<Integer>());

            String s[] = read.readLine().trim().split("\\s+");
            int p = 0;
            for (int i = 1; i <= edg; i++) {
                int u = Integer.parseInt(s[p++]);
                int v = Integer.parseInt(s[p++]);
                list.get(u).add(v);
            }

            int[] res = new TopologicalSort().topoSort(list, nov);

            if (check(list, nov, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }

    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v])
                    return false;
            }
        }
        return true;
    }
}
// } Driver Code Ends

/* Complete the function below */

/*
 * ArrayList<ArrayList<>Integer>adj: to represent graph containing 'N' vertices
 * and edges between them N: represent number of vertices
 */
class TopologicalSort {
    static int[] topoSort(ArrayList<ArrayList<Integer>> adj, int n) {
        int arr[] = new int[n];
        Stack<Integer> real = new Stack<>();
        boolean vis[] = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (vis[i]) {
                continue;
            }
            vis[i] = true;
            ArrayList<Integer> al = adj.get(i);
            if (al.size() == 0) {
                real.push(i);
            } else {
                helper(adj, al, real, vis);
                real.push(i);
            }
        }
        int count = 0;
        while (!real.isEmpty()) {
            arr[count++] = real.pop();
        }
        return arr;
    }

    static void helper(ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> al, Stack<Integer> real, boolean vis[]) {
        if (al.size() == 0) {
            return;
        }
        for (int i = 0; i < al.size(); i++) {
            int cur = al.get(i);
            if (vis[cur]) {
                continue;
            }
            vis[cur] = true;
            helper(adj, adj.get(al), real, vis);
            real.push(cur);
        }
    }
}
