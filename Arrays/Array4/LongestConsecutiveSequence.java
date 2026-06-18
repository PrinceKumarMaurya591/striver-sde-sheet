package Array4;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(lcs.longestConsecutive(nums)); // Output: 4
    }

    // Function to find the length of the longest consecutive sequence in an array
    // The function takes an array of integers as input and returns the length of the longest consecutive sequence
    // The function uses a hashset approach to solve the problem
    // The time complexity of the function is O(n), where n is the length of the array. The space complexity is O(n) due to the hashset used to store the elements.

    // Approach: Add all elements to a hashset for O(1) lookup.
    // Iterate through the array and for each element, check if it is the start of a sequence (i.e., num - 1 is not in the set).
    // If it is the start, count the length of the consecutive sequence by checking num + 1, num + 2, etc. in the set.
    // Keep track of the maximum length seen so far.
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums) { // Add all elements to the set
            set.add(num);
        }

        int maxLength = 0;

        for (int num : nums) {
            // Check if the current element is the start of a sequence
            if (!set.contains(num - 1)) { // If num-1 is not in the set, num is the start of a sequence
                int currentNum = num;
                int currentLength = 1;

                // Count the length of the consecutive sequence
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                maxLength = Math.max(maxLength, currentLength); // Update the maximum length
            }
        }

        return maxLength;
    }

}
