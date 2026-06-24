package LinkedList.LinkedList2;

public class DetectCycle {

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
        DetectCycle dc = new DetectCycle();
        // Create a linked list with a cycle: 3 -> 2 -> 0 -> -4 -> (back to 2)
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        head.next = node2;
        node2.next = node0;
        node0.next = node4;
        node4.next = node2; // Creates a cycle

        boolean hasCycle = dc.hasCycle(head);
        System.out.println("Has cycle: " + hasCycle);
    }

    // Function to detect if a linked list has a cycle.
    // Time complexity: O(n), Space complexity: O(1).

    // Approach: We use Floyd's Cycle Detection Algorithm
    // (Tortoise and Hare). The slow pointer moves one step,
    // the fast pointer moves two steps. If they meet, there
    // is a cycle. If fast reaches null, there is no cycle.
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true; // Cycle detected
            }
        }

        return false; // No cycle
    }

}
