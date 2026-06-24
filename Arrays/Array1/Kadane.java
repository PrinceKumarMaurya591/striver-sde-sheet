package Array1;

public class Kadane {

    public static void main(String[] args) {
        Kadane kd = new Kadane();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSum = kd.maxSubArray(nums);
        System.out.println("Maximum subarray sum is: " + maxSum);
    }

    // Function to find the maximum subarray sum using Kadane's Algorithm.
    // The function takes an array of integers as input and returns
    // the maximum sum of any contiguous subarray.
    // The time complexity of the function is O(n), where n is the
    // length of the array. The space complexity is O(1) as we are
    // using a constant amount of extra space.

    // Approach: We maintain two variables: maxSoFar (maximum sum
    // ending at the current position) and maxOverall (maximum sum
    // found so far). For each element, we decide whether to start a
    // new subarray or extend the existing one by taking the maximum
    // of the current element and the sum of the current element plus
    // the previous subarray sum. We update maxOverall with the larger
    // of maxOverall and maxSoFar at each step.
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int maxOverall = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Either extend the existing subarray or start a new one
            maxSoFar = Math.max(nums[i], maxSoFar + nums[i]);
            // Update the overall maximum
            maxOverall = Math.max(maxOverall, maxSoFar);
        }

        return maxOverall;
    }

}
