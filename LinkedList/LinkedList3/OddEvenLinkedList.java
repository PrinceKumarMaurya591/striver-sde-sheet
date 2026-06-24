package LinkedList.LinkedList3;

public class OddEvenLinkedList {

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
        OddEvenLinkedList oell = new OddEvenLinkedList();
        // Create a list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1,
                new ListNode(2,
                    new ListNode(3,
                        new ListNode(4,
                            new ListNode(5)))));

        System.out.print("Original: ");
        printList(head);

        ListNode result = oell.oddEvenList(head);
        System.out.print("Odd-Even grouped: ");
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

    // Function to group all odd-indexed nodes together followed
    // by even-indexed nodes. Indexing starts from 1.
    // Time complexity: O(n), Space complexity: O(1).

    // Approach: We maintain two pointers: odd and even. The odd
    // pointer starts at head (index 1) and the even pointer starts
    // at head.next (index 2). We connect odd nodes to odd nodes
    // and even nodes to even nodes. At the end, we connect the
    // last odd node to the first even node.
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even; // Save the first even node

        while (even != null && even.next != null) {
            odd.next = even.next; // Connect odd to next odd
            odd = odd.next;
            even.next = odd.next; // Connect even to next even
            even = even.next;
        }

        odd.next = evenHead; // Connect odd tail to even head

        return head;
    }

}
