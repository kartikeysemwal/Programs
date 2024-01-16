// import java.util.*;

// class TestClass {

// static class Node {
// String val;
// int lock_count;
// int locked_by;
// boolean dir_locked; // Directly locked
// Node parent;
// ArrayList<String> children;

// Node(String val, Node parent) {
// this.val = val;
// lock_count = 0;
// locked_by = 0;
// dir_locked = false;
// this.parent = parent;
// children = new ArrayList<>();
// }
// }

// public boolean lockNode(String val, int userId, HashMap<String, Node>
// map_node) {

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

// if (type == 1) {
// // Lock
// Node node = map_node.get(val);

// if (node.lock_count > 0 || node.dir_locked) {
// sb.append("false").append("\n");
// continue;
// }

// // Check any ancestor locked
// boolean locked = false;
// Node temp = node.parent;
// while (temp != null) {
// if (temp.dir_locked) {
// locked = true;
// break;
// }
// temp = temp.parent;
// }
// if (locked) {
// sb.append("false").append("\n");
// continue;
// }
// sb.append("true").append("\n");

// node.dir_locked = true;
// node.locked_by = userId;

// // Make all parent lock_count increase by 1
// temp = node.parent;
// while (temp != null) {
// temp.lock_count = temp.lock_count + 1;
// temp = temp.parent;
// }

// } else if (type == 2) {
// // Unlock
// Node node = map_node.get(val);
// if (!node.dir_locked || node.locked_by != userId) {
// sb.append("false").append("\n");
// continue;
// }

// node.dir_locked = false;
// node.locked_by = -1;
// // Make all parent lock_count decrease by one
// Node temp = node.parent;
// while (temp != null) {
// temp.lock_count = temp.lock_count - 1;
// temp = temp.parent;
// }
// sb.append("true").append("\n");

// } else {
// Node node = map_node.get(val);
// // Upgrade Lock
// // To check whether this node is locked or not
// if (node.dir_locked || node.children.size() == 0
// || (node.children.size() != 0 && node.lock_count == 0)) {
// sb.append("false").append("\n");
// continue;
// }

// // Check whether all nodes are locked and are locked by the same userId
// // BFS for traversal
// boolean poss = true;
// queue = new LinkedList<>();
// queue.add(node);
// boolean first_time = true;

// while (!queue.isEmpty()) {
// Node rem = queue.remove();
// if (!first_time && (rem.dir_locked && rem.locked_by != userId)) {
// poss = false;
// break;
// }
// first_time = false;
// for (String child : rem.children) {
// Node cur_child = map_node.get(child);
// queue.add(cur_child);
// }
// }

// if (!poss) {
// sb.append("false").append("\n");
// continue;
// }

// // Unlock all of its children
// queue = new LinkedList<>();
// queue.add(node);
// int count_child = node.lock_count;

// while (!queue.isEmpty()) {
// Node rem = queue.remove();
// rem.dir_locked = false;
// rem.lock_count = 0;
// rem.locked_by = -1;

// for (String child : rem.children) {
// Node cur_child = map_node.get(child);
// queue.add(cur_child);
// }
// }

// // Increase lock count of all its parent
// Node temp = node.parent;
// while (temp != null) {
// temp.lock_count = temp.lock_count - count_child + 1;
// temp = temp.parent;
// }
// // Lock this node
// node.dir_locked = true;
// node.locked_by = userId;
// node.lock_count = 0;
// sb.append("true").append("\n");
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
