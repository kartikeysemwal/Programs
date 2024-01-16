// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class DetectCycleGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int nov = sc.nextInt();
            int edg = sc.nextInt();

            for (int i = 0; i < nov + 1; i++)
                list.add(i, new ArrayList<Integer>());

            for (int i = 1; i <= edg; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            if (new DetectCycle().isCyclic(list, nov) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends

// User function Template for Java

/*
 * ArrayList<ArrayList<Integer>> g: represent graph containing 'V' number of
 * vertices and edges between them V: represent number of vertices
 */
class DetectCycle {
    static boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean vis[] = new boolean[v];
        boolean rec[] = new boolean[v];
        boolean ans = false;
        for (int i = 0; i < v && !ans; i++)
            ans = findCycle(adj, i, vis, rec, i);
        return ans;
    }

    static boolean findCycle(ArrayList<ArrayList<Integer>> adj, int cur, boolean vis[], boolean rec[], int parent) {
        if (rec[cur] && cur != parent) {
            return true;
        }
        if (vis[cur]) {
            return false;
        }
        vis[cur] = true;
        rec[cur] = true;
        boolean ans = false;
        ArrayList<Integer> al = adj.get(cur);
        for (int i = 0; i < al.size() && !ans; i++) {
            int c = al.get(i);
            ans = findCycle(adj, c, vis, rec, parent);
        }
        rec[cur] = false;
        return ans;
    }
}
