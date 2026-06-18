package Array4;

import java.util.HashMap;
import java.util.Map;

public class SubarraysXOR {

    public static void main(String[] args) {
        SubarraysXOR sx = new SubarraysXOR();
        int[] nums = {4, 2, 2, 6, 4};
        int target = 6;
        System.out.println(sx.subarraysXOR(nums, target)); // Output: 4
    }

    // Function to count the number of subarrays with XOR equal to a target value
    // The function takes an array of integers and a target integer as input and returns the count of subarrays whose XOR is equal to the target
    // The function uses a hashmap approach to solve the problem by storing prefix XOR values and their frequencies
    // The time complexity of the function is O(n), where n is the length of the array. The space complexity is O(n) due to the hashmap used to store prefix XOR values.

    // Approach: Calculate the prefix XOR as we iterate through the array.
    // If the prefix XOR is equal to the target, increment the count (subarray from index 0 to i).
    // For each prefix XOR, check if (prefix XOR ^ target) exists in the map.
    // If it does, it means there is a subarray whose XOR is equal to the target, so add its frequency to the count.
    // The reason: if prefixXOR ^ k = target, then k = prefixXOR ^ target, where k is the previous prefix XOR.
    // Store the frequency of each prefix XOR in the map for future lookups.
    public int subarraysXOR(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // Map to store prefix XOR values and their frequencies
        int count = 0;
        int prefixXOR = 0;

        for (int num : nums) {
            prefixXOR ^= num; // XOR the current element with the running prefix XOR

            if (prefixXOR == target) { // If the prefix XOR itself is equal to the target, increment count
                count++;
            }

            // Check if there is a previous prefix XOR such that prefixXOR ^ k = target => k = prefixXOR ^ target
            int requiredXOR = prefixXOR ^ target;
            if (map.containsKey(requiredXOR)) {
                count += map.get(requiredXOR); // Add the number of subarrays ending at this index with XOR = target
            }

            // Update the frequency of the current prefix XOR in the map
            map.put(prefixXOR, map.getOrDefault(prefixXOR, 0) + 1);
        }

        return count;
    }

}
