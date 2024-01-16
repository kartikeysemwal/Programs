class Node {
    int val;
    Node left, right;

    public Node(int val) {
        this.val = val;
        left = right = null;
    }
}

// A class to represent a tree
class Tree {
    Node root;

    public Tree() {
        root = null;
    }

    // concatenate both the lists and returns the head
    // of the List
    public Node concatenate(Node leftList, Node rightList) {
        // If either of the list is empty, then
        // return the other list
        if (leftList == null)
            return rightList;
        if (rightList == null)
            return leftList;

        // Store the last Node of left List
        Node leftLast = leftList.left;

        // Store the last Node of right List
        Node rightLast = rightList.left;

        // Connect the last node of Left List
        // with the first Node of the right List
        leftLast.right = rightList;
        rightList.left = leftLast;

        // left of first node refers to
        // the last node in the list
        leftList.left = rightLast;

        // Right of last node refers to the first
        // node of the List
        rightLast.right = leftList;

        // Return the Head of the List
        return leftList;
    }

    static boolean firstTime = true;
    static Node headNode;
    static Node lastNode;
    static Node lastRight;

    // side 0 left side 1 right
    static Node inOrder(Node head, int side) {
        if (head == null) {
            return null;
        }
        Node left = inOrder(head.left, 0);
        // System.out.print(head.data + " ");
        Node toAdd = new Node(head.val);
        if (left == null) {
            lastRight = toAdd;
        }
        if (firstTime) {
            headNode = toAdd;
            firstTime = false;
        }
        toAdd.left = left;
        if (left != null)
            left.right = toAdd;
        Node right = inOrder(head.right, 1);
        if (right == null) {
            lastNode = toAdd;
        }
        toAdd.right = right;
        if (right != null && (side == 0 || side == -1)) {
            right.left = toAdd;
            return lastNode;
        }
        if (left != null && side == 1) {
            return lastRight;
        }
        return toAdd;
    }

    public Node bTreeToClist(Node root) {
        if (root == null) {
            return root;
        }
        inOrder(root, -1);
        if (headNode != null && lastNode != null) {
            headNode.left = lastNode;
            lastNode.right = headNode;
            return headNode;
        }
        return headNode;
    }

    // Display Circular Link List
    public void display(Node head) {
        System.out.println("Circular Linked List is :");
        Node itr = head;
        do {
            System.out.print(itr.val + " ");
            itr = itr.right;
        } while (itr != head);
        System.out.println();
    }
}

// Driver Code
class CDLLTOBT {
    public static void main(String args[]) {
        // Build the tree
        Tree tree = new Tree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.left = new Node(4);
        tree.root.right.left.right = new Node(5);
        tree.root.right.left.right.left = new Node(7);
        tree.root.right.right = new Node(6);
        // tree.root.left.right = new Node(30);
        // tree.root.right.left = new Node(36);

        // head refers to the head of the Link List
        Node head = tree.bTreeToClist(tree.root);

        // Display the Circular LinkedList
        tree.display(head);
    }
}
