package Strings;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(lcp.longestCommonPrefix(strs)); // Output: "fl"
    }

    // Function to find the longest common prefix among an array of strings
    // The function takes an array of strings as input and returns the longest common prefix string
    // The function uses a horizontal scanning approach to solve the problem
    // The time complexity of the function is O(S), where S is the sum of all characters in all strings. The space complexity is O(1) as we are using a constant amount of extra space.

    // Approach: Start with the first string as the initial prefix.
    // For each subsequent string, keep reducing the prefix until it matches the start of the current string.
    // If the prefix becomes empty at any point, return an empty string immediately.
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) { // If the array is empty, return an empty string
            return "";
        }

        String prefix = strs[0]; // Start with the first string as the initial prefix

        for (int i = 1; i < strs.length; i++) {
            // While the current string does not start with the prefix, shorten the prefix
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1); // Remove the last character from the prefix
                if (prefix.isEmpty()) { // If the prefix becomes empty, there is no common prefix
                    return "";
                }
            }
        }

        return prefix;
    }

}
