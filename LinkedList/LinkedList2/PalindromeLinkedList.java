package LinkedList.LinkedList2;

public class PalindromeLinkedList {

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
        PalindromeLinkedList pll = new PalindromeLinkedList();
        // Create a palindrome list: 1 -> 2 -> 2 -> 1
        ListNode head = new ListNode(1,
                new ListNode(2,
                    new ListNode(2,
                        new ListNode(1))));

        boolean isPalin = pll.isPalindrome(head);
        System.out.println("Is palindrome: " + isPalin);
    }

    // Function to check if a linked list is a palindrome.
    // Time complexity: O(n), Space complexity: O(1).

    // Approach: We find the middle of the list using slow/fast
    // pointers. Then we reverse the second half of the list.
    // Finally, we compare the first half with the reversed
    // second half element by element.
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // Find the middle of the list
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half
        ListNode secondHalf = reverseList(slow);

        // Compare first and second halves
        ListNode firstHalf = head;
        ListNode secondCopy = secondHalf;
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
