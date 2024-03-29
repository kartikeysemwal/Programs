// { Driver Code Starts
//Initial Template for Java

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class FixingNodesOfBST {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    static class pair {
        int first;
        int second;

        pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length)
                break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static void printInorder(Node root) {
        if (root == null)
            return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static boolean isBST(Node n, int lower, int upper) {
        if (n == null)
            return true;
        if (n.data <= lower || n.data >= upper)
            return false;
        return (isBST(n.left, lower, n.data) && isBST(n.right, n.data, upper));
    }

    public static boolean compare(Node a, Node b, ArrayList<pair> mismatch) {
        if (a == null && b == null)
            return true;
        if (a == null || b == null)
            return false;

        if (a.data != b.data) {
            pair temp = new pair(a.data, b.data);
            mismatch.add(temp);
        }

        return (compare(a.left, b.left, mismatch) && compare(a.right, b.right, mismatch));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Node duplicate = buildTree(s);

            root = correctBST(root);

            // check 1: is tree now a BST
            if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE) == false) {
                System.out.println(0);
                continue;
            }

            // check 2: comparing with duplicate tree

            ArrayList<pair> mismatch = new ArrayList<pair>();
            // an arraylist to store data of mismatching nodes

            if (compare(root, duplicate, mismatch) == false) {
                // false output from this function indicates change in structure of tree
                System.out.println(0);
                continue;
            }

            // finally, analysing the mismatching nodes
            if (mismatch.size() != 2 || mismatch.get(0).first != mismatch.get(1).second
                    || mismatch.get(0).second != mismatch.get(1).first)
                System.out.println(0);
            else
                System.out.println(1);

        }
    }

    static Node n1 = null, n2 = null;

    static Node correctBST(Node root) {
        if (root == null) {
            return null;
        }
        ArrayList<Node> al = new ArrayList<>();
        // correct(root);
        isBST(root, al);
        int temp = n1.data;
        n1.data = n2.data;
        n2.data = temp;

        return root;

    }

    static void correct(Node root) {
        if (root == null) {
            return;
        }
        if (root.left != null && root.left.data > root.data) {
            if (n1 == null)
                n1 = root.left;
            if (n2 == null)
                n2 = root.left;
        }
        correct(root.left);
        if (root.right != null && root.right.data < root.data) {
            if (n1 == null)
                n1 = root.right;
            if (n2 == null)
                n2 = root.right;
        }
        correct(root.right);
    }

    static boolean isBST(Node root, ArrayList<Node> al) {
        if (root == null) {
            return true;
        }
        inOrder(root, al);
        int n = al.size();
        for (int i = 0; i < n; i++) {
            if (i == 0 && al.get(i).data > al.get(i + 1).data) {
                n1 = al.get(i);
                continue;
            }
            if (i == n - 1 && al.get(n-2).data >) {
            }
        }
        return true;
    }

    static void inOrder(Node root, ArrayList<Node> al) {
        if (root == null) {
            return;
        }
        inOrder(root.left, al);
        al.add(root);
        inOrder(root.right, al);
    }
}
