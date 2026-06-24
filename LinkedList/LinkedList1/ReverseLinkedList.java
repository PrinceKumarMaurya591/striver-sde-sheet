package LinkedList.LinkedList1;

public class ReverseLinkedList {

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
        ReverseLinkedList rll = new ReverseLinkedList();
        // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1,
                new ListNode(2,
                    new ListNode(3,
                        new ListNode(4,
                            new ListNode(5)))));

        System.out.print("Original list: ");
        printList(head);

        ListNode reversed = rll.reverseList(head);
        System.out.print("Reversed list: ");
        printList(reversed);
    }

    // Helper method to print the linked list
    private static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Function to reverse a singly linked list.
    // The function takes the head of the linked list as input
    // and returns the new head of the reversed list.
    // Time complexity: O(n), Space complexity: O(1).

    // Approach: We use three pointers: prev, curr, and next.
    // We iterate through the list, reversing the next pointer
    // of each node to point to the previous node.
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next; // Store next node
            curr.next = prev;          // Reverse the link
            prev = curr;               // Move prev forward
            curr = next;               // Move curr forward
        }

        return prev; // New head of the reversed list
    }

}
