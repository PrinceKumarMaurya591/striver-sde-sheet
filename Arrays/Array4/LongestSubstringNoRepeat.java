package Array4;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringNoRepeat {

    public static void main(String[] args) {
        LongestSubstringNoRepeat ls = new LongestSubstringNoRepeat();
        String s = "abcabcbb";
        System.out.println(ls.lengthOfLongestSubstring(s)); // Output: 3
    }

    // Function to find the length of the longest substring without repeating characters
    // The function takes a string as input and returns the length of the longest substring without repeating characters
    // The function uses a sliding window approach with a hashmap to solve the problem
    // The time complexity of the function is O(n), where n is the length of the string. The space complexity is O(min(n, m)), where m is the size of the character set.

    // Approach: Use a sliding window technique with two pointers (left and right).
    // Maintain a hashmap to store the most recent index of each character.
    // Expand the right pointer and if the current character is already in the map and its index is within the current window,
    // move the left pointer to the right of the previous occurrence of that character.
    // Update the maximum length of the window at each step.
    // Store the current character's index in the map.
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>(); // Map to store the most recent index of each character
        int maxLength = 0;
        int left = 0; // Left pointer of the sliding window

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If the character is already in the map and its index is within the current window, move the left pointer
            if (map.containsKey(currentChar) && map.get(currentChar) >= left) {
                left = map.get(currentChar) + 1; // Move left to the right of the previous occurrence
            }

            map.put(currentChar, right); // Update the most recent index of the current character
            maxLength = Math.max(maxLength, right - left + 1); // Update the maximum length of the window
        }

        return maxLength;
    }

}
