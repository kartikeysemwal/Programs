// { Driver Code Starts
//Initial Template for Java

//Contributed by Sudarshan Sharma
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class VerticalTraversal {
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
            String s = br.readLine();
            Node root = buildTree(s);
            ArrayList<Integer> res = verticalOrder(root);
            for (Integer num : res)
                System.out.print(num + " ");
            System.out.println();

        }
    }

    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    static ArrayList<Integer> verticalOrder(Node root) {
        if (root == null) {
            return null;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        traverse(root, map, 0);
        for (int i = min; i <= max; i++) {
            ArrayList<Integer> al = map.get(i);
            while (al != null && !al.isEmpty()) {
                ans.add(al.remove(al.size() - 1));
            }
        }
        return ans;
    }

    static void traverse(Node root, HashMap<Integer, ArrayList<Integer>> map, int level) {
        if (root == null) {
            return;
        }
        traverse(root.left, map, level - 1);
        ArrayList<Integer> al = new ArrayList<>();
        if (min > level) {
            min = level;
        }
        if (max < level) {
            max = level;
        }
        if (map.containsKey(level)) {
            al = map.get(level);
        }
        al.add(root.data);
        map.put(level, al);
        traverse(root.right, map, level + 1);
    }
}
