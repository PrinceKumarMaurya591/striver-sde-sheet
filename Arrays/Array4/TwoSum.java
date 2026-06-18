package Array4;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = ts.twoSum(nums, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]); // Output: Indices: 0, 1
    }

    // Function to find two indices whose values add up to a target sum
    // The function takes an array of integers and a target integer as input and returns an array of two indices
    // The function uses a hashmap approach to solve the problem
    // The time complexity of the function is O(n), where n is the length of the array. The space complexity is O(n) due to the hashmap used to store the elements and their indices.

    // Approach: Use a hashmap to store each element and its index as we iterate through the array.
    // For each element, calculate the complement (target - current element).
    // If the complement exists in the hashmap, we have found the two indices and return them.
    // Otherwise, store the current element and its index in the hashmap.
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // Map to store element value and its index

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // Calculate the complement needed to reach the target

            if (map.containsKey(complement)) { // If the complement exists in the map, we found the pair
                return new int[]{map.get(complement), i}; // Return the indices of the complement and current element
            }

            map.put(nums[i], i); // Store the current element and its index in the map
        }

        return new int[]{-1, -1}; // No solution found (should not happen as per problem constraints)
    }

}
