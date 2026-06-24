package LinkedList.LinkedList3;

public class SwapNodesInPairs {

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
        SwapNodesInPairs snp = new SwapNodesInPairs();
        // Create a list: 1 -> 2 -> 3 -> 4
        ListNode head = new ListNode(1,
                new ListNode(2,
                    new ListNode(3,
                        new ListNode(4))));

        System.out.print("Original: ");
        printList(head);

        ListNode result = snp.swapPairs(head);
        System.out.print("Swapped in pairs: ");
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

    // Function to swap every two adjacent nodes in a linked list.
    // Time complexity: O(n), Space complexity: O(1).

    // Approach: We use a dummy node and three pointers: prev, first,
    // and second. We swap each pair by adjusting the next pointers.
    // The prev pointer helps connect the swapped pair to the rest
    // of the list.
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = prev.next.next;

            // Swap the pair
            first.next = second.next;
            second.next = first;
            prev.next = second;

            // Move prev forward
            prev = first;
        }

        return dummy.next;
    }

}
