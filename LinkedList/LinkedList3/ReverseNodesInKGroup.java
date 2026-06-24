package LinkedList.LinkedList3;

public class ReverseNodesInKGroup {

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
        ReverseNodesInKGroup rnk = new ReverseNodesInKGroup();
        // Create a list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1,
                new ListNode(2,
                    new ListNode(3,
                        new ListNode(4,
                            new ListNode(5)))));

        System.out.print("Original: ");
        printList(head);

        ListNode result = rnk.reverseKGroup(head, 2);
        System.out.print("Reversed in groups of 2: ");
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

    // Function to reverse nodes in k-group. Nodes are reversed in
    // groups of size k. If the number of nodes is not a multiple
    // of k, the remaining nodes remain as-is.
    // Time complexity: O(n), Space complexity: O(n/k) for recursion.

    // Approach: We recursively reverse k nodes at a time. First,
    // we check if there are at least k nodes remaining. If yes,
    // we reverse the first k nodes using iterative reversal and
    // recursively process the rest. We connect the reversed part
    // with the result of the recursive call.
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        // Check if there are at least k nodes
        ListNode curr = head;
        int count = 0;
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        if (count == k) {
            // Reverse first k nodes
            ListNode prev = null;
            ListNode currNode = head;
            for (int i = 0; i < k; i++) {
                ListNode next = currNode.next;
                currNode.next = prev;
                prev = currNode;
                currNode = next;
            }

            // Recursively reverse the remaining list
            head.next = reverseKGroup(currNode, k);
            return prev;
        }

        return head; // Less than k nodes, no reversal
    }

}
