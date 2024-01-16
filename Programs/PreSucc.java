// { Driver Code Starts

import java.util.*;

class PreSucc {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static class Res {
        Node pre = null;
        Node succ = null;
    }

    public static void insert(Node root, int a, int a1, char lr) {
        if (root == null) {
            return;
        }
        if (root.data == a) {
            switch (lr) {
                case 'L':
                    root.left = new Node(a1);
                    break;
                case 'R':
                    root.right = new Node(a1);
                    break;
            }
            return;
        }
        insert(root.left, a, a1, lr);
        insert(root.right, a, a1, lr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            if (n == 0) {
                System.out.println(0);
                continue;
            }
            Node root = null;
            Res p = new Res();
            Res s = new Res();
            for (int i = 0; i < n; i++) {

                int a = sc.nextInt();
                int a1 = sc.nextInt();

                char lr = sc.next().charAt(0);

                if (i == 0) {

                    root = new Node(a);

                    switch (lr) {

                        case 'L':
                            root.left = new Node(a1);
                            break;
                        case 'R':
                            root.right = new Node(a1);
                            break;
                    }
                } else {
                    insert(root, a, a1, lr);
                }
            }

            int key = sc.nextInt();
            findPreSuc(root, p, s, key);

            if (p.pre != null)
                System.out.print(p.pre.data + " ");
            else
                System.out.print("-1" + " ");

            if (s.succ != null)
                System.out.println(s.succ.data);
            else
                System.out.println("-1");

        }
    }

    public static void findPreSuc(Node root, Res p, Res s, int key) {
        if (root == null) {
            return;
        }
        if (root.data == key) {
            Node temp = root.left;
            while (temp != null && temp.right != null) {
                temp = temp.right;
            }
            if (temp != null)
                p.pre = temp;
            temp = root.right;
            while (temp != null && temp.left != null) {
                temp = temp.left;
            }
            if (temp != null)
                s.succ = temp;
        }
        if (key < root.data) {
            s.succ = root;
            findPreSuc(root.left, p, s, key);
        } else if (key > root.data) {
            p.pre = root;
            findPreSuc(root.right, p, s, key);
        }
    }
}