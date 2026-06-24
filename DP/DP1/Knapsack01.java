package DP.DP1;

public class Knapsack01 {

    public static void main(String[] args) {
        Knapsack01 ks = new Knapsack01();
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int capacity = 5;

        int maxVal = ks.knapsack(weights, values, capacity);
        System.out.println("Maximum value: " + maxVal);
    }

    // Function to solve the 0/1 Knapsack problem using DP.
    // Time complexity: O(n * W), Space complexity: O(W).

    // Approach: Use 1D DP array. For each item, iterate capacity
    // from right to left. dp[w] = max(dp[w], dp[w-weight[i]] +
    // value[i]). This represents the maximum value achievable
    // with capacity w considering items seen so far.
    public int knapsack(int[] weights, int[] values,
                        int capacity) {
        int n = weights.length;
        int[] dp = new int[capacity + 1];

        for (int i = 0; i < n; i++) {
            for (int w = capacity; w >= weights[i]; w--) {
                dp[w] = Math.max(dp[w],
                        dp[w - weights[i]] + values[i]);
            }
        }

        return dp[capacity];
    }

}
