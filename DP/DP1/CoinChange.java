package DP.DP1;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        int[] coins = {1, 2, 5};
        int amount = 11;

        int minCoins = cc.coinChange(coins, amount);
        System.out.println("Minimum coins needed: " + minCoins);
    }

    // Function to find the minimum number of coins needed to
    // make a given amount (unlimited supply of each coin).
    // Time complexity: O(n * amount), Space: O(amount).

    // Approach: Initialize dp array with a large value (amount+1).
    // dp[0] = 0. For each amount from 1 to target, try each coin.
    // If coin <= amount, dp[amount] = min(dp[amount],
    // dp[amount - coin] + 1).
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

}
