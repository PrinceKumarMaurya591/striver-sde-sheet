package BinarySearch;

import java.util.Arrays;

public class AggressiveCows {

    public static void main(String[] args) {
        AggressiveCows ac = new AggressiveCows();
        int[] stalls = { 1, 2, 8, 4, 9 };
        int cows = 3;
        System.out.println(ac.aggressiveCows(stalls, cows)); // Output: 3
    }

    // Function to find the maximum minimum distance between aggressive cows placed
    // in stalls
    // The function takes an array of stall positions and a number of cows as input
    // and returns the largest minimum distance
    // The function uses a binary search approach on the answer to solve the problem
    // The time complexity of the function is O(n log maxDistance), where n is the
    // number of stalls. The space complexity is O(1) as we are using a constant
    // amount of extra space.

    // Approach: Sort the stall positions. The answer lies between 1 and (max - min)
    // distance.
    // Use binary search to find the maximum possible minimum distance.
    // For each mid value, check if we can place all cows with at least mid distance
    // between them.
    // If feasible, try a larger distance (move left = mid + 1). Otherwise, try a
    // smaller distance (move right = mid - 1).
    public int aggressiveCows(int[] stalls, int cows) {
        Arrays.sort(stalls); // Sort the stall positions

        int n = stalls.length;
        int low = 1; // Minimum possible distance between cows
        int high = stalls[n - 1] - stalls[0]; // Maximum possible distance between cows
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Guess for the minimum distance between cows

            if (canPlaceCows(stalls, cows, mid)) {
                result = mid; // This distance is feasible, try a larger distance
                low = mid + 1;
            } else {
                high = mid - 1; // Need a smaller distance
            }
        }

        return result;
    }

    // Helper function to check if we can place all cows with at least minDist
    // distance between them
    private boolean canPlaceCows(int[] stalls, int cows, int minDist) {
        int cowsPlaced = 1; // Place the first cow at the first stall
        int lastPosition = stalls[0]; // Position of the last placed cow

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPosition >= minDist) {
                // Place the next cow here if the distance is at least minDist
                cowsPlaced++;
                lastPosition = stalls[i];

                if (cowsPlaced == cows) { // All cows have been placed
                    return true;
                }
            }
        }

        return false; // Could not place all cows
    }

}
