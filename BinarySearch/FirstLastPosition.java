package BinarySearch;

import java.util.Arrays;

public class FirstLastPosition {

    public static void main(String[] args) {
        FirstLastPosition fl = new FirstLastPosition();
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        int target = 8;
        int[] result = fl.searchRange(nums, target);
        System.out.println("First: " + result[0] + ", Last: " + result[1]); // Output: First: 3, Last: 4
    }

    // Function to find the first and last position of a target in a sorted array
    // The function takes a sorted array and a target as input and returns an array
    // [first, last] of indices
    // The function uses two separate binary searches to solve the problem
    // The time complexity of the function is O(log n), where n is the length of the
    // array. The space complexity is O(1) as we are using a constant amount of
    // extra space.

    // Approach: Perform two separate binary searches.
    // First binary search: Find the first occurrence of the target (lower bound).
    // Second binary search: Find the last occurrence of the target (upper bound).
    // In both searches, when we find the target, we continue searching in the
    // appropriate direction
    // to find the boundary instead of stopping immediately.
    public int[] searchRange(int[] nums, int target) {
        int[] result = { -1, -1 }; // Default result if target is not found

        result[0] = findFirst(nums, target); // Find the first occurrence
        if (result[0] != -1) { // If the target exists, find the last occurrence
            result[1] = findLast(nums, target);
        }

        return result;
    }

    // Helper function to find the first occurrence of the target
    private int findFirst(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int first = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                first = mid; // Record this position
                right = mid - 1; // Continue searching in the left half for an earlier occurrence
            } else if (nums[mid] < target) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }

        return first;
    }

    // Helper function to find the last occurrence of the target
    private int findLast(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int last = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                last = mid; // Record this position
                left = mid + 1; // Continue searching in the right half for a later occurrence
            } else if (nums[mid] < target) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }

        return last;
    }

}
