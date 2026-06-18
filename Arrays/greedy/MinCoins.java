package greedy;

public class MinCoins {


    public static void main(String[] args) {
        MinCoins minCoins = new MinCoins();
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(minCoins.minCoins(coins, amount)); // Output: 3
    }

    // Function to find the minimum number of coins required to make a given amount
    // The function takes an array of coin denominations and an integer amount as input
    // The function returns an integer representing the minimum number of coins required to make the given amount
    // The function uses a greedy approach to solve the problem by iterating through the coin denominations in descending order and subtracting the coin value from the amount until the amount becomes zero
    // The time complexity of the function is O(n), where n is the number of coin denominations. The space complexity is O(1) as we are using a constant amount of extra space.

//Approach: Iterate through the coin denominations in descending order.
// For each coin denomination, subtract the coin value from the amount until the amount becomes zero.
// Keep track of the count of coins used and return the total count at the end.


    public int minCoins(int[] coins, int amount) {
        int count = 0;
        // Iterate through the coin denominations in descending order
        for (int i = coins.length - 1; i >= 0; i--) {
            while (amount >= coins[i]) { // While the amount is greater than or equal to the coin value
                amount -= coins[i]; // Subtract the coin value from the amount
                count++; // Increment the count of coins used
            }
        }
        return count; // Return the total count of coins used
    }

    
}
