/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Deque<Integer> queue = new LinkedList<>();
            for (int i = 0; i < k; i++) {
                while (queue.size() > 0 && arr[queue.peekLast()] < arr[i]) {
                    queue.removeLast();
                }
                queue.addLast(i);
            }
            for (int i = 0; i < n - k; i++) {
                sb.append(arr[queue.getFirst()] + " ");
                while (queue.size() > 0 && queue.peekFirst() < i + 1) {
                    queue.removeFirst();
                }
                while (queue.size() > 0 && arr[queue.peekLast()] < arr[i + k]) {
                    queue.removeLast();
                }
                queue.addLast(i + k);
            }
            sb.append(arr[queue.getFirst()] + "\n");
        }
        System.out.print(sb);
    }
}