package LinkedList.LinkedList1;

public class MergeTwoSortedLists {

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
        MergeTwoSortedLists mtsl = new MergeTwoSortedLists();
        // List 1: 1 -> 2 -> 4
        ListNode list1 = new ListNode(1,
                new ListNode(2,
                    new ListNode(4)));
        // List 2: 1 -> 3 -> 4
        ListNode list2 = new ListNode(1,
                new ListNode(3,
                    new ListNode(4)));

        ListNode merged = mtsl.mergeTwoLists(list1, list2);
        System.out.print("Merged list: ");
        printList(merged);
    }

    private static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Function to merge two sorted linked lists into one sorted list.
    // Time complexity: O(n + m), Space complexity: O(1).

    // Approach: We use a dummy node to simplify the merging process.
    // We compare the heads of both lists and append the smaller node
    // to the result. We continue until one list is exhausted, then
    // append the remaining nodes from the other list.
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        // Append remaining nodes from either list
        tail.next = (list1 != null) ? list1 : list2;

        return dummy.next;
    }

}
