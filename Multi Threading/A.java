import java.util.*;

class Lock {
    int read_count;
    int write_count;

    Lock() {
        read_count = 0;
        write_count = 0;
    }

    void incrRead() {
        read_count++;
    }

    void decRead() {
        read_count--;
    }

    void incrWrite() {
        write_count++;
    }

    void decWrite() {
        write_count--;
    }

}

public class A {

    static Lock lock;

    static class Node {
        String val;
        int lock_count;
        int locked_by;
        boolean dir_locked; // Directly locked
        Node parent;
        ArrayList<String> children;

        Node(String val, Node parent) {
            this.val = val;
            lock_count = 0;
            locked_by = 0;
            dir_locked = false;
            this.parent = parent;

            children = new ArrayList<>();
        }
    }

    static boolean isPossible(Node node) {

        Node temp = node.parent;

        while (lock.write_count > 0) {
            // A pseudo way to wait until all write operations are performed
        }

        // Check any parent executing
        lock.incrRead();

        while (temp != null) {
            if (temp.dir_locked) {
                return false;
            }
            temp = temp.parent;
        }

        lock.decRead();

        return true;
    }

    static void increaseParentCount(Node node) {

        while (lock.read_count > 0) {

        }

        lock.incrWrite();

        Node temp = node.parent;
        while (temp != null) {
            temp.lock_count = temp.lock_count + 1;
            temp = temp.parent;
        }

        lock.decWrite();

    }

    static boolean lockNode(Node node, int userId, HashMap<String, Node> map_node) {

        if (node.lock_count > 0 || node.dir_locked) {
            return false;
        }

        // Make the node as locked
        node.dir_locked = true;

        if (!isPossible(node)) {
            node.dir_locked = false;
            return false;
        }

        node.locked_by = userId;

        // Make all parent lock_count increase by 1
        // operation

        increaseParentCount(node);

        return true;
    }

    static boolean unlockNode(String val, int userId, HashMap<String, Node> map_node) {
        Node node = map_node.get(val);
        if (!node.dir_locked || node.locked_by != userId) {
            return false;
        }

        node.dir_locked = false;
        node.locked_by = -1;
        // Make all parent lock_count decrease by one
        Node temp = node.parent;
        while (temp != null) {
            temp.lock_count = temp.lock_count - 1;
            temp = temp.parent;
        }
        return true;
    }

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();

        Queue<Node> queue = new LinkedList<>();
        HashMap<String, Node> map_node = new HashMap<>();

        Node root = new Node(sc.next(), null);
        queue.add(root);
        map_node.put(root.val, root);

        int count = 1;

        while (count < n) {
            Node rem = queue.remove();
            for (int i = 0; i < m && count < n; i++) {
                Node cur = new Node(sc.next(), rem);
                rem.children.add(cur.val);
                queue.add(cur);
                count++;
                map_node.put(cur.val, cur);
            }
        }

        lock = new Lock();

        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();
            String val = sc.next();
            int userId = sc.nextInt();

            Node node = map_node.get(val);

            if (type == 1) {
                // Lock
                boolean ans = lockNode(node, userId, map_node);
                sb.append(ans).append("\n");
            } else if (type == 2) {
                // Unlock
                boolean ans = lockNode(node, userId, map_node);
                sb.append(ans).append("\n");

            }

        }
        System.out.print(sb);
    }
}

/*
 * Two lock thread conflict:
 * 
 * If either of them is direct parent or children then it will lead to race
 * condition and arise conflict between the locking operation of two nodes.
 * Otherwise there will not be any conflict We just have to take care of
 * synchronization in the ancestor node variables when we will be editing them.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
