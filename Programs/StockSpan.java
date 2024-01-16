/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class StockSpan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            int values[] = new int[n];
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                values[i] = 1;

                while (stack.size() > 0 && stack.peek() <= arr[i]) {
                    values[i] += values[stack.pop()];
                }
                stack.push(i);
            }
            for (int i = 0; i < n; i++) {
                sb.append(values[i] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}