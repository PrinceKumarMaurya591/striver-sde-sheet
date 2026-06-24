package DP.DP1;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        LongestIncreasingSubsequence lis =
                new LongestIncreasingSubsequence();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

        int len = lis.lengthOfLIS(nums);
        System.out.println("LIS length: " + len);
    }

    // Function to find the length of the longest increasing
    // subsequence.
    // Time complexity: O(n log n), Space complexity: O(n).

    // Approach: Use patience sorting with a binary search.
    // Maintain an array 'tails' where tails[i] is the smallest
    // possible tail value for an increasing subsequence of
    // length i+1. For each num, find its position in tails
    // using binary search and update it.
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int len = 0;

        for (int num : nums) {
            int pos = Arrays.binarySearch(tails, 0, len, num);
            if (pos < 0) pos = -(pos + 1);

            tails[pos] = num;
            if (pos == len) len++;
        }

        return len;
    }

}
