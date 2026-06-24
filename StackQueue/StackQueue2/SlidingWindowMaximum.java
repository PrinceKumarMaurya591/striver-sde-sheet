package StackQueue.StackQueue2;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        SlidingWindowMaximum swm = new SlidingWindowMaximum();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = swm.maxSlidingWindow(nums, k);
        System.out.print("Sliding window maximums: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    // Function to find the maximum element in each sliding
    // window of size k.
    // Time complexity: O(n), Space complexity: O(k).

    // Approach: We use a deque (double-ended queue) that stores
    // indices of elements in decreasing order of their values.
    // For each window position, the front of the deque contains
    // the index of the maximum element. We remove indices that
    // are out of the current window and indices of elements
    // smaller than the current element.
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return new int[0];

        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // Remove indices out of the current window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove indices of elements smaller than current
            while (!deque.isEmpty() &&
                    nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            // Add the maximum of the current window to result
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

}
