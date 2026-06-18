package Heap;

import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class MergeKSortedLists {

    public static void main(String[] args) {
        MergeKSortedLists mkl = new MergeKSortedLists();

        // Create sample sorted linked lists
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(2, new ListNode(6));

        ListNode[] lists = {l1, l2, l3};
        ListNode result = mkl.mergeKLists(lists);

        // Output the merged list
        while (result != null) {
            System.out.print(result.val + " "); // Output: 1 1 2 3 4 4 5 6
            result = result.next;
        }
    }

    // Function to merge k sorted linked lists into one sorted linked list
    // The function takes an array of ListNode heads as input and returns the head of the merged sorted linked list
    // The function uses a min-heap (priority queue) approach to solve the problem
    // The time complexity of the function is O(n log k), where n is the total number of nodes and k is the number of lists. The space complexity is O(k) for the heap.

    // Approach: Use a min-heap to store the heads of all k linked lists.
    // While the heap is not empty, poll the smallest node from the heap and add it to the result list.
    // If the polled node has a next node, push the next node into the heap.
    // Continue until all nodes are processed.
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) { // If there are no lists, return null
            return null;
        }

        // Min-heap to store the nodes, sorted by their value
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the head of each non-empty list to the heap
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }

        ListNode dummy = new ListNode(0); // Dummy node to simplify the result list construction
        ListNode current = dummy;

        while (!minHeap.isEmpty()) {
            ListNode smallest = minHeap.poll(); // Get the smallest node from the heap
            current.next = smallest; // Add it to the result list
            current = current.next; // Move the pointer forward

            if (smallest.next != null) { // If the polled node has a next node, add it to the heap
                minHeap.offer(smallest.next);
            }
        }

        return dummy.next; // Return the head of the merged list (skip the dummy node)
    }

}
