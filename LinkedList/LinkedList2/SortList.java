package LinkedList.LinkedList2;

public class SortList {

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
        SortList sl = new SortList();
        // Create an unsorted list: 4 -> 2 -> 1 -> 3
        ListNode head = new ListNode(4,
                new ListNode(2,
                    new ListNode(1,
                        new ListNode(3))));

        System.out.print("Original: ");
        printList(head);

        ListNode sorted = sl.sortList(head);
        System.out.print("Sorted: ");
        printList(sorted);
    }

    private static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Function to sort a linked list in ascending order using
    // merge sort (top-down approach).
    // Time complexity: O(n log n), Space complexity: O(log n)
    // due to recursion stack.

    // Approach: We use merge sort on the linked list. We find
    // the middle of the list using slow/fast pointers, recursively
    // sort both halves, and then merge the sorted halves.
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Find the middle of the list
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Split the list into two halves
        prev.next = null;

        // Recursively sort both halves
        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        // Merge the sorted halves
        return merge(left, right);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        tail.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }

}
