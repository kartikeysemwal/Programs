// { Driver Code Starts
//Initial Template for Java

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class CheckIfSubtree {
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String tt = br.readLine();
            Node rootT = buildTree(tt);

            String s = br.readLine();
            Node rootS = buildTree(s);
            // printInorder(root);

            boolean st = isSubtree(rootT, rootS);
            if (st == true) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }

    public static void findNode(Node node, int x, ArrayList<Node> al) {
        if (node == null) {
            return;
        }
        if (node.data == x) {
            al.add(node);
        }
        findNode(node.left, x, al);
        findNode(node.right, x, al);
    }

    public static boolean checkSubtree(Node org, Node sub) {
        if (org == null && sub == null) {
            return true;
        }
        if ((org == null && sub != null) || (org != null && sub == null)) {
            return false;
        }
        if (org.data != sub.data) {
            return false;
        }
        boolean ans;
        ans = checkSubtree(org.left, sub.left);
        if (ans == true) {
            ans = checkSubtree(org.right, sub.right);
        }
        return ans;
    }

    public static boolean isSubtree(Node org, Node sub) {
        // add code here.
        ArrayList<Node> al = new ArrayList<>();
        findNode(org, sub.data, al);
        boolean ans = false;
        for (int i = 0; i < al.size() && ans != true; i++) {
            Node orgStart = al.get(i);
            if (orgStart == null) {
                ans = false;
            }
            ans = checkSubtree(orgStart, sub);
        }
        return ans;
    }
}