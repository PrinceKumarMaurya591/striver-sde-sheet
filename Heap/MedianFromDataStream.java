package Heap;

import java.util.PriorityQueue;

public class MedianFromDataStream {

    public static void main(String[] args) {
        MedianFromDataStream mds = new MedianFromDataStream();
        mds.addNum(1);
        mds.addNum(2);
        System.out.println(mds.findMedian()); // Output: 1.5
        mds.addNum(3);
        System.out.println(mds.findMedian()); // Output: 2.0
    }

    // Class to find the median of a stream of numbers
    // The class uses two heaps approach: a max-heap for the left half and a min-heap for the right half
    // The time complexity of addNum is O(log n) and findMedian is O(1). The space complexity is O(n) for storing the elements.

    // Approach: Maintain two heaps:
    // 1. A max-heap (left half) that stores the smaller half of the numbers
    // 2. A min-heap (right half) that stores the larger half of the numbers
    // The max-heap is always at most one element larger than the min-heap.
    // The median is the root of the max-heap if sizes differ, or the average of the two roots if sizes are equal.

    private PriorityQueue<Integer> maxHeap; // Left half (stores smaller numbers)
    private PriorityQueue<Integer> minHeap; // Right half (stores larger numbers)

    public MedianFromDataStream() {
        // Max-heap for the left half (use reverse order comparator)
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        // Min-heap for the right half (default natural order)
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // Step 1: Add the number to the appropriate heap
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num); // Add to the left half if num is less than or equal to the max of the left half
        } else {
            minHeap.offer(num); // Add to the right half otherwise
        }

        // Step 2: Balance the heaps to maintain the size property
        // maxHeap can have at most one more element than minHeap
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll()); // Move the largest element from maxHeap to minHeap
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll()); // Move the smallest element from minHeap to maxHeap
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            // If maxHeap has more elements, the median is the root of maxHeap
            return (double) maxHeap.peek();
        } else {
            // If both heaps have the same size, the median is the average of the two roots
            return (double) (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }

}
