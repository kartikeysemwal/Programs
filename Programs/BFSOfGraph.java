// { Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class BFSOfGraph {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int nov = sc.nextInt();
            int edg = sc.nextInt();

            for (int i = 0; i < nov; i++)
                list.add(i, new ArrayList<Integer>());

            for (int i = 1; i <= edg; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            ArrayList<Integer> res = new Traversal().bfs(list, nov);
            for (int i = 0; i < res.size(); i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends

// User function Template for Java

/*
 * g[]: adj list of the graph N : number of vertices
 */
class Traversal {
    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> g, int n) {
        boolean vis[] = new boolean[n];
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()) {
            int remove = q.remove();
            if (vis[remove])
                continue;
            ans.add(remove);
            vis[remove] = true;
            ArrayList<Integer> al = g.get(remove);
            for (int j = 0; j < al.size(); j++) {
                q.add(al.get(j));
            }

        }
        return ans;
    }
}
