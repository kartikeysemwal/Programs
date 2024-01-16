/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class SnakeAndLadder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            int arr[] = new int[31];
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                arr[a] = b;
            }
            Queue<Integer> q = new LinkedList<>();
            int moves[] = new int[31];
            int minimum = Integer.MAX_VALUE;
            q.add(1);
            moves[1] = 0;
            boolean vis[] = new boolean[31];
            while (!q.isEmpty()) {
                int index = q.remove();
                for (int i = 1; i <= 6; i++) {
                    int toGo = index + i;
                    if (toGo > 30) {
                        continue;
                    }
                    if (arr[toGo] != 0 && arr[toGo] < toGo) {
                        continue;
                    }
                    if (arr[toGo] != 0) {
                        toGo = arr[toGo];
                    }
                    if (moves[toGo] == 0) {
                        moves[toGo] = moves[index] + 1;
                    } else {
                        moves[toGo] = Math.min(moves[toGo], moves[index] + 1);
                    }
                    if (toGo == 30) {
                        minimum = Math.min(minimum, moves[toGo]);
                        continue;
                    }
                    if (vis[toGo]) {
                        continue;
                    }
                    q.add(toGo);
                    vis[toGo] = true;
                }
            }
            System.out.println(minimum);
        }
    }
}