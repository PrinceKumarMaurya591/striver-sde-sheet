package DP.DP1;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        LongestCommonSubsequence lcs =
                new LongestCommonSubsequence();
        String text1 = "abcde";
        String text2 = "ace";

        int len = lcs.longestCommonSubsequence(text1, text2);
        System.out.println("LCS length: " + len);
    }

    // Function to find the length of the longest common
    // subsequence between two strings.
    // Time complexity: O(m * n), Space complexity: O(n).

    // Approach: Use 2D DP. If characters match, dp[i][j] =
    // dp[i-1][j-1] + 1. Otherwise, dp[i][j] =
    // max(dp[i-1][j], dp[i][j-1]).
    public int longestCommonSubsequence(String text1,
                                        String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) ==
                        text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j],
                            dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

}
