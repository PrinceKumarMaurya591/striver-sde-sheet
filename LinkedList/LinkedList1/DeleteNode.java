package LinkedList.LinkedList1;

public class DeleteNode {

    // Definition for singly-linked list
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static void main(String[] args) {
        DeleteNode dn = new DeleteNode();
        // Create a sample linked list: 4 -> 5 -> 1 -> 9
        ListNode head = new ListNode(4);
        ListNode nodeToDelete = new ListNode(5);
        head.next = nodeToDelete;
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);

        System.out.print("Original list: ");
        printList(head);

        dn.deleteNode(nodeToDelete);
        System.out.print("After deleting node 5: ");
        printList(head);
    }

    private static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Function to delete a node in a linked list given only
    // access to that node. The node to delete is not the tail.
    // Time complexity: O(1), Space complexity: O(1).

    // Approach: Since we don't have access to the previous node,
    // we copy the value and next pointer of the next node into
    // the current node, effectively skipping the next node.
    public void deleteNode(ListNode node) {
        // Copy the value of the next node into the current node
        node.val = node.next.val;
        // Skip the next node
        node.next = node.next.next;
    }

}
