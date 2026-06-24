package LinkedList.LinkedList3;

public class FlattenLinkedList {

    // Node with next (horizontal) and child (vertical) pointers
    public static class Node {
        int val;
        Node next;
        Node child;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        FlattenLinkedList fll = new FlattenLinkedList();
        // Create a multilevel linked list
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        head.child = new Node(7);
        head.child.next = new Node(8);

        head.child.child = new Node(10);

        Node flattened = fll.flatten(head);
        System.out.print("Flattened list: ");
        printList(flattened);
    }

    private static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Function to flatten a multilevel linked list. Nodes have
    // next and child pointers. Child pointers point to separate
    // vertical lists that need to be merged into the main list.
    // Time complexity: O(n), Space complexity: O(n) for recursion.

    // Approach: We traverse the list recursively. For each node,
    // if it has a child, we recursively flatten the child list
    // and insert it between the current node and its next node.
    // We find the tail of the flattened child list and connect it.
    public Node flatten(Node head) {
        flattenHelper(head);
        return head;
    }

    private Node flattenHelper(Node head) {
        Node curr = head;
        Node tail = head;

        while (curr != null) {
            Node next = curr.next;

            // If current node has a child, flatten it
            if (curr.child != null) {
                Node childTail = flattenHelper(curr.child);

                // Insert the child list between curr and next
                curr.next = curr.child;
                curr.child = null;

                // Connect the tail of child list to next
                if (next != null) {
                    childTail.next = next;
                }

                // Update tail to the child tail
                tail = childTail;
            } else {
                tail = curr;
            }

            curr = next;
        }

        return tail;
    }

}
