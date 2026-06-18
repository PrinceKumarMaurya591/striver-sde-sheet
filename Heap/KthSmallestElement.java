package Heap;

import java.util.PriorityQueue;

public class KthSmallestElement {

    public static void main(String[] args) {
        KthSmallestElement kse = new KthSmallestElement();
        int[] nums = {7, 10, 4, 3, 20, 15};
        int k = 3;
        System.out.println(kse.findKthSmallest(nums, k)); // Output: 7
    }

    // Function to find the kth smallest element in an array
    // The function takes an array of integers and an integer k as input and returns the kth smallest element
    // The function uses a max-heap (priority queue with reverse order) approach to solve the problem
    // The time complexity of the function is O(n log k), where n is the length of the array. The space complexity is O(k) for the heap.

    // Approach: Use a max-heap of size k to keep track of the k smallest elements seen so far.
    // Iterate through the array and add each element to the heap.
    // If the heap size exceeds k, remove the largest element (poll from the max-heap).
    // After processing all elements, the root of the heap (peek) is the kth smallest element.
    public int findKthSmallest(int[] nums, int k) {
        // Max-heap to store the k smallest elements (the largest of these is the kth smallest)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int num : nums) {
            maxHeap.offer(num); // Add the current element to the heap

            if (maxHeap.size() > k) { // If the heap size exceeds k, remove the largest element
                maxHeap.poll(); // Remove the largest element from the heap
            }
        }

        return maxHeap.peek(); // The root of the max-heap is the kth smallest element
    }

}
