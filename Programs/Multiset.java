import java.util.*;

public class Multiset {
    static class Node {
        int data;
        Node next;

        Node(int key) {
            data = key;
            next = null;
        }
    }

    public static Node[] reverseList(Node head) {
        Node n[] = new Node[2];
        n[1] = head;
        if (head == null || head.next == null) {
            return n;
        }
        Node cur = head.next;
        Node prev = head;
        Node morePrev = null;
        while (cur != null) {
            prev.next = morePrev;
            morePrev = prev;
            prev = cur;
            cur = cur.next;
        }
        prev.next = morePrev;
        head = prev;
        n[0] = head;
        return n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int freq[] = new int[n + 1];
        int pre[] = new int[n + 2];

        for (int i = 0; i < n; i++) {
            int cur = sc.nextInt();
            freq[cur]++;
        }
        for (int i = 0; i < k; i++) {
            int q = sc.nextInt();
            if (q >= 1) {
                freq[q]++;
            } else if (q < 0) {
                int count = 0;
                int index = 1;
                q = Math.abs(q);
                while (count < q) {
                    count += freq[index];
                    if (count < q) {
                        index++;
                    }
                }
                freq[index]--;
            }
        }
        for (int i = 1; i < n + 1; i++) {
            if (freq[i] > 0) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}