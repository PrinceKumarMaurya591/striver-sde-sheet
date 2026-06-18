package Array4;

import java.util.HashMap;
import java.util.Map;

public class LargestSubarrayZeroSum {

    public static void main(String[] args) {
        LargestSubarrayZeroSum lsz = new LargestSubarrayZeroSum();
        int[] nums = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println(lsz.maxLen(nums)); // Output: 5
    }

    // Function to find the length of the largest subarray with a sum of 0
    // The function takes an array of integers as input and returns the length of the largest subarray whose sum is 0
    // The function uses a hashmap approach to solve the problem by storing prefix sums and their first occurrence indices
    // The time complexity of the function is O(n), where n is the length of the array. The space complexity is O(n) due to the hashmap used to store prefix sums.

    // Approach: Calculate the prefix sum as we iterate through the array.
    // If the prefix sum is 0, the subarray from index 0 to i has a sum of 0.
    // If the prefix sum has been seen before at some index j, then the subarray from j+1 to i has a sum of 0.
    // Use a hashmap to store the first occurrence of each prefix sum.
    // Keep track of the maximum length of such subarrays.
    public int maxLen(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // Map to store prefix sum and its first occurrence index
        int maxLength = 0;
        int prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i]; // Add the current element to the prefix sum

            if (prefixSum == 0) { // If prefix sum is 0, the subarray from index 0 to i has sum 0
                maxLength = i + 1; // Update maxLength to include all elements from start to current index
            } else {
                if (map.containsKey(prefixSum)) { // If this prefix sum was seen before, we found a zero-sum subarray
                    // Subarray from (first occurrence index + 1) to i has sum 0
                    int length = i - map.get(prefixSum);
                    maxLength = Math.max(maxLength, length); // Update maxLength if this subarray is longer
                } else {
                    map.put(prefixSum, i); // Store the first occurrence of this prefix sum
                }
            }
        }

        return maxLength;
    }

}
