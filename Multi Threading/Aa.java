// import java.util.*;

// public class A {

// static class Node {
// String val;
// int lock_count;
// int locked_by;
// boolean dir_locked; // Directly locked
// Node parent;
// ArrayList<String> children;

// boolean isExecuting;
// int isChildrenExecuting;

// Node(String val, Node parent) {
// this.val = val;
// lock_count = 0;
// locked_by = 0;
// dir_locked = false;
// this.parent = parent;

// isExecuting = false;
// isChildrenExecuting = 0;

// children = new ArrayList<>();
// }
// }

// static synchronized void increaseParentCount(Node node) {
// Node temp = node.parent;
// while (temp != null) {
// temp.lock_count = temp.lock_count + 1;
// temp = temp.parent;
// }
// }

// static synchronized boolean isPossible(Node node) {
// if (node.isExecuting || node.isChildrenExecuting != 0) {
// return false;
// }

// // Check any parent executing
// Node temp = node.parent;
// while (temp != null) {
// if (temp.isExecuting || temp.dir_locked) {
// return false;
// }
// temp = temp.parent;
// }

// // This node can start operation
// node.isExecuting = true;
// temp = node.parent;

// while (temp != null) {
// temp.isChildrenExecuting = temp.isChildrenExecuting + 1;
// temp = temp.parent;
// }

// return true;
// }

// static synchronized void stopExecution(Node node) {
// node.isExecuting = false;
// Node temp = node.parent;
// while (temp != null) {
// temp.isChildrenExecuting = temp.isChildrenExecuting - 1;
// temp = temp.parent;
// }
// }

// static boolean lockNode(Node node, int userId, HashMap<String, Node>
// map_node) {

// if (node.lock_count > 0 || node.dir_locked) {
// return false;
// }

// // Check any ancestor locked

// if (!isPossible(node)) {
// return false;
// }

// node.dir_locked = true;
// node.locked_by = userId;

// // Make all parent lock_count increase by 1
// // synchronized operation
// increaseParentCount(node);
// stopExecution(node);

// return true;
// }

// static boolean unlockNode(String val, int userId, HashMap<String, Node>
// map_node) {
// Node node = map_node.get(val);
// if (!node.dir_locked || node.locked_by != userId) {
// return false;
// }

// node.dir_locked = false;
// node.locked_by = -1;
// // Make all parent lock_count decrease by one
// Node temp = node.parent;
// while (temp != null) {
// temp.lock_count = temp.lock_count - 1;
// temp = temp.parent;
// }
// return true;
// }

// public static void main(String args[]) throws Exception {
// Scanner sc = new Scanner(System.in);
// StringBuilder sb = new StringBuilder();
// int n = sc.nextInt();
// int m = sc.nextInt();
// int q = sc.nextInt();

// Queue<Node> queue = new LinkedList<>();
// HashMap<String, Node> map_node = new HashMap<>();

// Node root = new Node(sc.next(), null);
// queue.add(root);
// map_node.put(root.val, root);

// int count = 1;

// while (count < n) {
// Node rem = queue.remove();
// for (int i = 0; i < m && count < n; i++) {
// Node cur = new Node(sc.next(), rem);
// rem.children.add(cur.val);
// queue.add(cur);
// count++;
// map_node.put(cur.val, cur);
// }
// }

// for (int i = 0; i < q; i++) {
// int type = sc.nextInt();
// String val = sc.next();
// int userId = sc.nextInt();

// Node node = map_node.get(val);

// if (type == 1) {
// // Lock
// boolean ans = lockNode(node, userId, map_node);
// sb.append(ans).append("\n");
// } else if (type == 2) {
// // Unlock
// boolean ans = lockNode(node, userId, map_node);
// sb.append(ans).append("\n");

// }
// }
// System.out.print(sb);
// }
// }

// /*
// * Two lock thread conflict:
// *
// * If either of them is direct parent or children then it will lead to race
// * condition and arise conflict between the locking operation of two nodes.
// * Otherwise there will not be any conflict We just have to take care of
// * synchronization in the ancestor node variables when we will be editing
// them.
// *
// *
// *
// *
// *
// *
// *
// *
// *
// *
// *
// *
// *
// *
// *
// *
// *
// *
// *
// *
// */
