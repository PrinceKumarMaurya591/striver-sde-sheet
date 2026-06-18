package Array2;

import java.util.Arrays;

public class RepeatAndMissing {

    public static void main(String[] args) {
        RepeatAndMissing rm = new RepeatAndMissing();
        int[] nums = {3, 1, 2, 5, 3};
        int[] result = rm.findErrorNums(nums);
        System.out.println("Repeating: " + result[0] + ", Missing: " + result[1]); // Output: Repeating: 3, Missing: 4
    }

    // Function to find the repeating and missing numbers in an array of size n with elements in the range [1, n]
    // The function takes an array of integers as input and returns an array where the first element is the repeating number and the second element is the missing number
    // The function uses a mathematical approach to solve the problem using the sum and sum of squares formulas
    // The time complexity of the function is O(n), where n is the length of the array. The space complexity is O(1) as we are using a constant amount of extra space.

    // Approach: Let the repeating number be R and the missing number be M.
    // Calculate the actual sum and sum of squares of the array elements.
    // Calculate the expected sum and sum of squares for numbers from 1 to n.
    // The difference in sums (actual - expected) gives R - M.
    // The difference in sum of squares (actual - expected) gives R^2 - M^2 = (R - M)(R + M).
    // Using these two equations, we can solve for R and M.
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;

        // Calculate actual sum and sum of squares of the array elements
        long actualSum = 0;
        long actualSumSq = 0;
        for (int num : nums) {
            actualSum += num;
            actualSumSq += (long) num * num; // Cast to long to avoid integer overflow
        }

        // Calculate expected sum and sum of squares for numbers from 1 to n
        long expectedSum = (long) n * (n + 1) / 2;
        long expectedSumSq = (long) n * (n + 1) * (2 * n + 1) / 6;

        // diff1 = R - M (repeating - missing)
        long diff1 = actualSum - expectedSum;

        // diff2 = R^2 - M^2 = (R - M)(R + M)
        long diff2 = actualSumSq - expectedSumSq;

        // R + M = diff2 / diff1
        long sumRM = diff2 / diff1;

        // R = (diff1 + sumRM) / 2
        int repeating = (int) (diff1 + sumRM) / 2;

        // M = sumRM - R
        int missing = (int) (sumRM - repeating);

        return new int[]{repeating, missing};
    }

}
