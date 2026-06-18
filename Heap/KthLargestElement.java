package Heap;

import java.util.PriorityQueue;

public class KthLargestElement {

    public static void main(String[] args) {
        KthLargestElement kle = new KthLargestElement();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(kle.findKthLargest(nums, k)); // Output: 5
    }

    // Function to find the kth largest element in an array
    // The function takes an array of integers and an integer k as input and returns the kth largest element
    // The function uses a min-heap (priority queue) approach to solve the problem
    // The time complexity of the function is O(n log k), where n is the length of the array. The space complexity is O(k) for the heap.

    // Approach: Use a min-heap of size k to keep track of the k largest elements seen so far.
    // Iterate through the array and add each element to the heap.
    // If the heap size exceeds k, remove the smallest element (poll from the heap).
    // After processing all elements, the root of the heap (peek) is the kth largest element.
    public int findKthLargest(int[] nums, int k) {
        // Min-heap to store the k largest elements (the smallest of these is the kth largest)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num); // Add the current element to the heap

            if (minHeap.size() > k) { // If the heap size exceeds k, remove the smallest element
                minHeap.poll(); // Remove the smallest element from the heap
            }
        }

        return minHeap.peek(); // The root of the heap is the kth largest element
    }

}
