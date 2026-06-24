package Trie.Trie1;

import java.util.*;

public class WordBreak {

    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
        String s = "leetcode";
        List<String> wordDict = Arrays.asList(
                "leet", "code");

        boolean canBreak = wb.wordBreak(s, wordDict);
        System.out.println("Can break: " + canBreak);
    }

    // Function to check if a string can be segmented into
    // dictionary words.
    // Time complexity: O(n^2), Space complexity: O(n).

    // Approach: Use DP. dp[i] = true if s[0...i-1] can be
    // segmented. For each position i, check all j < i. If
    // dp[j] is true and s[j...i-1] is in the dictionary,
    // set dp[i] = true.
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(
                        s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

}
