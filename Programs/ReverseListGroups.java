class ReverseListGroups {
    static class Node {
        int data;
        Node next;

        Node(final int data) {
            this.data = data;
            this.next = null;
        }
    }

    ReverseListGroups.Node head;

    public void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    void printList() {
        for (ReverseListGroups.Node node = this.head; node != null; node = node.next) {
            System.out.print(node.data + " ");
        }
        System.out.println();
    }

    public static ReverseListGroups.Node reverse(final ReverseListGroups.Node node, final int n) {
        if (node == null || node.next == null) {
            return node;
        }
        ReverseListGroups.Node node2 = node.next;
        ReverseListGroups.Node node3 = node;
        ReverseListGroups.Node node4 = null;
        for (int n2 = 0; node2 != null && n2 < n; node2 = node2.next, ++n2) {
            node3.next = node4;
            node4 = node3;
            node3 = node2;
        }
        node3.next = node4;
        if (node2 != null) {
            node.next = reverse(node2, n);
        }
        return node;
    }

    public static void main(final String[] array) {
        final ReverseListGroups reverseListGroups = new ReverseListGroups();
        reverseListGroups.push(8);
        reverseListGroups.push(7);
        reverseListGroups.push(6);
        reverseListGroups.push(5);
        reverseListGroups.push(4);
        reverseListGroups.push(2);
        reverseListGroups.push(2);
        reverseListGroups.push(1);
        System.out.println("Given Linked List");
        reverseListGroups.printList();
        reverseListGroups.head = reverse(reverseListGroups.head, 4);
        System.out.println("Reversed list");
        reverseListGroups.printList();
    }
}