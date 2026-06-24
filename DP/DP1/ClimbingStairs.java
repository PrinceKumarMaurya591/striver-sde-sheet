package DP.DP1;

public class ClimbingStairs {

    public static void main(String[] args) {
        ClimbingStairs cs = new ClimbingStairs();
        int n = 5;
        int ways = cs.climbStairs(n);
        System.out.println("Ways to climb " + n + " stairs: "
                + ways);
    }

    // Function to count ways to climb n stairs (1 or 2 steps).
    // Time complexity: O(n), Space complexity: O(1).

    // Approach: This is essentially the Fibonacci sequence.
    // To reach step i, you can come from step i-1 (1 step) or
    // step i-2 (2 steps). So dp[i] = dp[i-1] + dp[i-2].
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int a = 1, b = 2;
        for (int i = 3; i <= n; i++) {
            int next = a + b;
            a = b;
            b = next;
        }
        return b;
    }

}
