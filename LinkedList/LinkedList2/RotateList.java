package LinkedList.LinkedList2;

public class RotateList {

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
        RotateList rl = new RotateList();
        // Create a list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1,
                new ListNode(2,
                    new ListNode(3,
                        new ListNode(4,
                            new ListNode(5)))));

        System.out.print("Original: ");
        printList(head);

        ListNode rotated = rl.rotateRight(head, 2);
        System.out.print("Rotated by 2: ");
        printList(rotated);
    }

    private static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Function to rotate a linked list to the right by k places.
    // Time complexity: O(n), Space complexity: O(1).

    // Approach: First, find the length of the list and connect
    // the tail to the head (making it a circular list). Then,
    // find the new tail position (len - k % len - 1) and break
    // the cycle. The node after the new tail becomes the new head.
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Find the length and tail of the list
        ListNode tail = head;
        int len = 1;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        // Make it a circular list
        tail.next = head;

        // Find the new tail position
        k = k % len;
        int stepsToNewTail = len - k - 1;
        ListNode newTail = head;
        for (int i = 0; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        // The new head is the node after new tail
        ListNode newHead = newTail.next;
        // Break the cycle
        newTail.next = null;

        return newHead;
    }

}
