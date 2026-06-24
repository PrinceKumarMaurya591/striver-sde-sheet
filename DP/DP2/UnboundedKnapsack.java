package DP.DP2;

public class UnboundedKnapsack {

    public static void main(String[] args) {
        UnboundedKnapsack uk = new UnboundedKnapsack();
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int capacity = 5;

        int maxVal = uk.unboundedKnapsack(
                weights, values, capacity);
        System.out.println("Maximum value: " + maxVal);
    }

    // Function to solve the unbounded knapsack problem where
    // each item can be taken any number of times.
    // Time complexity: O(n * W), Space complexity: O(W).

    // Approach: Same as 0/1 knapsack but iterate capacity from
    // left to right (instead of right to left) to allow using
    // the same item multiple times.
    public int unboundedKnapsack(int[] weights, int[] values,
                                 int capacity) {
        int[] dp = new int[capacity + 1];

        for (int i = 0; i < weights.length; i++) {
            for (int w = weights[i]; w <= capacity; w++) {
                dp[w] = Math.max(dp[w],
                        dp[w - weights[i]] + values[i]);
            }
        }

        return dp[capacity];
    }

}
