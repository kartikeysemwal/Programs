// { Driver Code Starts
//Initial Template for Java

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class BTtoBST {

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
        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Node rootA = binaryTreeToBST(root);
            printInorder(rootA);
            System.out.println();
            t--;
        }
    }

    static void inOrder(Node root, List<Integer> al) {
        if (root == null) {
            return;
        }
        inOrder(root.left, al);
        al.add(root.data);
        inOrder(root.right, al);
    }

    static int count = 0;

    static void createTree(Node root, List<Integer> al) {
        if (root == null) {
            return;
        }
        createTree(root.left, al);
        if (count < al.size())
            root.data = al.get(count++);
        // count = count + 1;
        createTree(root.right, al);
        createTree(root.right, al);
    }

    // The given root is the root of the Binary Tree
    // Return the root of the generated BST
    static Node binaryTreeToBST(Node root) {
        List<Integer> al = new ArrayList<>();
        inOrder(root, al);
        Collections.sort(al);
        createTree(root, al);
        return root;
    }
}