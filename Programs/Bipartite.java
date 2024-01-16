
// { Driver Code Starts
// Java program to find out whether a given graph is Bipartite or not
import java.util.*;
import java.lang.*;
import java.io.*;

class Bipartite {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int V = sc.nextInt();
            int[][] G = new int[V][V];
            for (int i = 0; i < V; i++)
                for (int j = 0; j < V; j++)
                    G[i][j] = sc.nextInt();
            GfG b = new GfG();
            if (b.isBipartite(G, V))
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends

/* Complete the function below */
class GfG {
    boolean isBipartite(int G[][], int n) {
        int color[] = new int[n];
        for (int i = 0; i < n; i++) {
            color[i] = -1;
        }
        color[0] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()) {
            int remove = q.remove();
            if (G[remove][remove] == 1) {
                return false;
            }
            for (int i = 0; i < n; i++) {
                if (G[remove][i] == 1 && color[i] == -1) {
                    color[i] = 1 - color[remove];
                    q.add(i);
                } else if (G[remove][i] == 1 && color[i] == color[remove]) {
                    return false;
                }
            }
        }
        return true;
    }
}
