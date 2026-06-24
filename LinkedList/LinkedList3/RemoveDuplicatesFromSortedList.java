package LinkedList.LinkedList3;

public class RemoveDuplicatesFromSortedList {

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
        RemoveDuplicatesFromSortedList rdf =
                new RemoveDuplicatesFromSortedList();
        // Create sorted list with duplicates: 1 -> 2 -> 2 -> 3 -> 3 -> 4
        ListNode head = new ListNode(1,
                new ListNode(2,
                    new ListNode(2,
                        new ListNode(3,
                            new ListNode(3,
                                new ListNode(4))))));

        System.out.print("Original: ");
        printList(head);

        ListNode result = rdf.deleteDuplicates(head);
        System.out.print("After removing duplicates: ");
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

    // Function to remove all duplicates from a sorted linked list
    // such that each element appears only once.
    // Time complexity: O(n), Space complexity: O(1).

    // Approach: Since the list is sorted, duplicates are adjacent.
    // We traverse the list and whenever we find a duplicate value,
    // we skip over it by adjusting the next pointer.
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next; // Skip duplicate
            } else {
                curr = curr.next;
            }
        }

        return head;
    }

}
