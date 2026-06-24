package DP.DP2;

public class EditDistance {

    public static void main(String[] args) {
        EditDistance ed = new EditDistance();
        String word1 = "horse";
        String word2 = "ros";

        int dist = ed.minDistance(word1, word2);
        System.out.println("Edit distance: " + dist);
    }

    // Function to find the minimum edit distance (Levenshtein
    // distance) between two strings. Operations: insert, delete,
    // replace.
    // Time complexity: O(m * n), Space complexity: O(n).

    // Approach: Use DP. If characters match, dp[i][j] =
    // dp[i-1][j-1]. Otherwise, dp[i][j] = 1 + min(insert,
    // delete, replace) = 1 + min(dp[i][j-1], dp[i-1][j],
    // dp[i-1][j-1]).
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int j = 0; j <= n; j++) dp[0][j] = j;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) ==
                        word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(
                            dp[i - 1][j],    // delete
                            Math.min(dp[i][j - 1],    // insert
                                     dp[i - 1][j - 1]) // replace
                    );
                }
            }
        }

        return dp[m][n];
    }

}
