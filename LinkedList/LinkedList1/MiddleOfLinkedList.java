package LinkedList.LinkedList1;

public class MiddleOfLinkedList {

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
        MiddleOfLinkedList mll = new MiddleOfLinkedList();
        // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1,
                new ListNode(2,
                    new ListNode(3,
                        new ListNode(4,
                            new ListNode(5)))));

        ListNode middle = mll.middleNode(head);
        System.out.println("Middle node value: " + middle.val);
    }

    // Function to find the middle node of a linked list.
    // If there are two middle nodes, return the second one.
    // Time complexity: O(n), Space complexity: O(1).

    // Approach: We use the slow and fast pointer technique
    // (Tortoise and Hare). The slow pointer moves one step at
    // a time while the fast pointer moves two steps. When the
    // fast pointer reaches the end, the slow pointer is at the
    // middle.
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

}
