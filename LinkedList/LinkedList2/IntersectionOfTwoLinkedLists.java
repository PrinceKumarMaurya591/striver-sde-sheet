package LinkedList.LinkedList2;

public class IntersectionOfTwoLinkedLists {

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
        IntersectionOfTwoLinkedLists iotl =
                new IntersectionOfTwoLinkedLists();

        // Create intersecting linked lists
        // List A: 4 -> 1 -> 8 -> 4 -> 5
        // List B:    5 -> 6 -> 1 -> 8 -> 4 -> 5
        ListNode intersect = new ListNode(8,
                new ListNode(4,
                    new ListNode(5)));

        ListNode headA = new ListNode(4,
                new ListNode(1, intersect));

        ListNode headB = new ListNode(5,
                new ListNode(6,
                    new ListNode(1, intersect)));

        ListNode result = iotl.getIntersectionNode(headA, headB);
        System.out.println("Intersection node value: "
                + (result != null ? result.val : "null"));
    }

    // Function to find the intersection node of two linked lists.
    // Time complexity: O(n + m), Space complexity: O(1).

    // Approach: We use two pointers. We calculate the lengths of
    // both lists and move the pointer of the longer list ahead by
    // the difference in lengths. Then we traverse both lists together
    // until they meet at the intersection node or reach null.
    public ListNode getIntersectionNode(ListNode headA,
                                         ListNode headB) {
        if (headA == null || headB == null) return null;

        int lenA = getLength(headA);
        int lenB = getLength(headB);

        // Move the pointer of the longer list ahead
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (lenB > lenA) {
            headB = headB.next;
            lenB--;
        }

        // Traverse both lists together
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    private int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

}
