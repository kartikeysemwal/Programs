/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class Boggle {
    static class Comp implements Comparator<String> {
        // Overriding compare()method of Comparator
        // for descending order of cgpa
        public int compare(String s1, String s2) {
            if (s1.compareTo(s2) < 0)
                return 1;
            return -1;
        }
    }

    static int size = 26;
    static Trie head;

    static class Trie {
        Trie child[] = new Trie[size];
        boolean leaf;

        Trie() {
            leaf = false;
            for (int i = 0; i < size; i++) {
                child[i] = null;
            }
        }
    }

    static void insert(Trie root, String str) {
        int n = str.length();
        Trie temp = root;

        for (int i = 0; i < n; i++) {
            char cur = str.charAt(i);
            int index = (cur < 95 ? cur - 'A' : cur - 'a');
            if (temp.child[index] == null) {
                temp.child[index] = new Trie();
            }
            temp = temp.child[index];
        }
        temp.leaf = true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int testCases = sc.nextInt();
        for (int t = 0; t < testCases; t++) {
            int num = sc.nextInt();
            sc.nextLine();
            Trie root = new Trie();
            head = root;
            for (int i = 0; i < num; i++) {
                String cur = sc.next();
                insert(root, cur);
            }
            int n = sc.nextInt();
            int m = sc.nextInt();

            char boggle[][] = new char[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    boggle[i][j] = sc.next().charAt(0);
                }
            }
            String str = "";
            PriorityQueue<String> ans = new PriorityQueue<String>();
            boolean vis[][] = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int value = (boggle[i][j] < 95 ? boggle[i][j] - 'A' : boggle[i][j] - 'a');
                    if (root.child[value] != null) {
                        str = str + boggle[i][j];
                        find(boggle, n, m, i, j, ans, str, vis, root.child[value]);
                        str = "";
                    }
                }
            }
            if (ans.size() == 0) {
                sb.append("-1").append("\n");
                continue;
            }
            while (!ans.isEmpty()) {
                sb.append(ans.remove() + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void find(char boggle[][], int n, int m, int i, int j, PriorityQueue<String> ans, String str,
            boolean vis[][], Trie root) {
        vis[i][j] = true;
        if (root.leaf == true && !ans.contains(str)) {
            ans.add(str);
        }
        for (int x = i - 1; x <= i + 1 && x < n; x++) {
            for (int y = j - 1; y <= j + 1 && y < m; y++) {
                if (x >= 0 && y >= 0 && !vis[x][y]) {
                    int value = (boggle[x][y] < 95 ? boggle[x][y] - 'A' : boggle[x][y] - 'a');
                    if (root.child[value] != null) {
                        str = str + boggle[x][y];
                        find(boggle, n, m, x, y, ans, str, vis, root.child[value]);
                        str = str.substring(0, str.length() - 1);
                    }
                }
            }
        }
        vis[i][j] = false;
    }
}