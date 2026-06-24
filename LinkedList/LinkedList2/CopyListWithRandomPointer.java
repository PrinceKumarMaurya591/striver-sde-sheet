package LinkedList.LinkedList2;

public class CopyListWithRandomPointer {

    // Definition for a Node with a random pointer
    public static class Node {
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {
        CopyListWithRandomPointer cl =
                new CopyListWithRandomPointer();
        // Create a list: 7 -> 13 -> 11 -> 10 -> 1 with random pointers
        Node head = new Node(7);
        Node node13 = new Node(13);
        Node node11 = new Node(11);
        Node node10 = new Node(10);
        Node node1 = new Node(1);

        head.next = node13;
        node13.next = node11;
        node11.next = node10;
        node10.next = node1;

        head.random = null;
        node13.random = head;
        node11.random = node1;
        node10.random = node11;
        node1.random = head;

        Node copied = cl.copyRandomList(head);
        System.out.println("Copied list node values: "
                + copied.val + " -> "
                + copied.next.val + " -> "
                + copied.next.next.val);
    }

    // Function to create a deep copy of a linked list with
    // random pointers.
    // Time complexity: O(n), Space complexity: O(1).

    // Approach: We use a three-step in-place algorithm.
    // 1. Create copy nodes and interleave them with original nodes.
    // 2. Set the random pointers for the copied nodes.
    // 3. Separate the copied list from the original list.
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1: Create copy nodes and interleave
        // A -> A' -> B -> B' -> C -> C'
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // Step 2: Set random pointers for copied nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Separate the copied list from original
        curr = head;
        Node dummy = new Node(0);
        Node copyCurr = dummy;
        while (curr != null) {
            copyCurr.next = curr.next;
            curr.next = curr.next.next;
            copyCurr = copyCurr.next;
            curr = curr.next;
        }

        return dummy.next;
    }

}
