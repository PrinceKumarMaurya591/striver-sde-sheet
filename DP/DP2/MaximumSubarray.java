package DP.DP2;

public class MaximumSubarray {

    public static void main(String[] args) {
        MaximumSubarray ms = new MaximumSubarray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int maxSum = ms.maxSubArray(nums);
        System.out.println("Maximum subarray sum: " + maxSum);
    }

    // Function to find the maximum subarray sum (Kadane's
    // Algorithm) using DP approach.
    // Time complexity: O(n), Space complexity: O(1).

    // Approach: dp[i] = maximum sum of subarray ending at i.
    // dp[i] = max(nums[i], dp[i-1] + nums[i]). Track the
    // maximum of all dp[i] values.
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int maxOverall = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxSoFar = Math.max(nums[i], maxSoFar + nums[i]);
            maxOverall = Math.max(maxOverall, maxSoFar);
        }

        return maxOverall;
    }

}
