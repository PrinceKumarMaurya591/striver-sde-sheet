package LinkedList.LinkedList1;

public class AddTwoNumbers {

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
        AddTwoNumbers atn = new AddTwoNumbers();
        // Number 1: 342 represented as 2 -> 4 -> 3
        ListNode l1 = new ListNode(2,
                new ListNode(4,
                    new ListNode(3)));
        // Number 2: 465 represented as 5 -> 6 -> 4
        ListNode l2 = new ListNode(5,
                new ListNode(6,
                    new ListNode(4)));

        ListNode sum = atn.addTwoNumbers(l1, l2);
        System.out.print("Sum: ");
        printList(sum); // Should print 7 -> 0 -> 8 (807)
    }

    private static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Function to add two numbers represented by linked lists.
    // Digits are stored in reverse order, each node contains a
    // single digit. Returns the sum as a linked list.
    // Time complexity: O(max(n, m)), Space complexity: O(max(n, m)).

    // Approach: We traverse both lists simultaneously, adding
    // corresponding digits along with any carry. We create a new
    // node for each digit of the sum. If one list is longer, we
    // continue with the remaining digits. If there's a carry after
    // processing all digits, we add an extra node.
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
        }

        return dummy.next;
    }

}
