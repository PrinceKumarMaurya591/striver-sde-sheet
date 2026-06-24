package LinkedList.LinkedList1;

public class RemoveNthFromEnd {

    // Definition for singly-linked list
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        RemoveNthFromEnd rnfe = new RemoveNthFromEnd();
        // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1,
                new ListNode(2,
                    new ListNode(3,
                        new ListNode(4,
                            new ListNode(5)))));

        System.out.print("Original list: ");
        printList(head);

        ListNode result = rnfe.removeNthFromEnd(head, 2);
        System.out.print("After removing 2nd from end: ");
        printList(result);
    }

    private static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Function to remove the Nth node from the end of a linked list.
    // Time complexity: O(n), Space complexity: O(1).

    // Approach: We use a dummy node and two pointers (fast and slow).
    // First, we move the fast pointer N steps ahead. Then we move
    // both pointers together until fast reaches the end. At that point,
    // slow is pointing to the node just before the one to delete.
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast pointer N steps ahead
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Delete the Nth node from the end
        slow.next = slow.next.next;

        return dummy.next;
    }

}
