package DP.DP2;

public class MatrixChainMultiplication {

    public static void main(String[] args) {
        MatrixChainMultiplication mcm =
                new MatrixChainMultiplication();
        int[] dims = {10, 20, 30, 40, 30};

        int minOps = mcm.matrixChainOrder(dims);
        System.out.println("Minimum operations: " + minOps);
    }

    // Function to find the minimum number of operations to
    // multiply a chain of matrices.
    // Time complexity: O(n^3), Space complexity: O(n^2).

    // Approach: Use DP. dp[i][j] = minimum operations to
    // multiply matrices from i to j. For each length from 2
    // to n, and for each i, compute j = i+len-1. Try all
    // possible k between i and j-1 to split the chain:
    // dp[i][j] = min(dp[i][k] + dp[k+1][j] +
    // dims[i-1] * dims[k] * dims[j]).
    public int matrixChainOrder(int[] dims) {
        int n = dims.length;
        int[][] dp = new int[n][n];

        for (int len = 2; len < n; len++) {
            for (int i = 1; i < n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] +
                            dims[i - 1] * dims[k] * dims[j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[1][n - 1];
    }

}
