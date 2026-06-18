package Strings2;

import java.util.ArrayList;
import java.util.List;

public class ZFunction {

    public static void main(String[] args) {
        ZFunction zf = new ZFunction();
        String text = "abcabcdabc";
        String pattern = "abc";
        List<Integer> result = zf.search(text, pattern);
        System.out.println(result); // Output: [0, 3, 6]
    }

    // Function to find all occurrences of a pattern in a text using the Z-algorithm
    // The function takes a text string and a pattern string as input and returns a list of starting indices where the pattern is found in the text
    // The function uses the Z-algorithm (linear time pattern matching) to solve the problem
    // The time complexity of the function is O(n + m), where n is the length of the text and m is the length of the pattern. The space complexity is O(n + m) for the Z-array and concatenated string.

    // Approach: Create a concatenated string: pattern + "$" + text, where "$" is a delimiter not present in either string.
    // Compute the Z-array for this concatenated string, where Z[i] is the length of the longest substring starting from i that matches the prefix of the string.
    // For each position i after the delimiter, if Z[i] equals the pattern length, it means the pattern is found starting at position (i - pattern length - 1) in the original text.
    public List<Integer> search(String text, String pattern) {
        String concat = pattern + "$" + text; // Concatenate pattern, delimiter, and text
        int n = concat.length();
        int[] Z = computeZArray(concat); // Compute the Z-array for the concatenated string

        List<Integer> result = new ArrayList<>();
        int patternLen = pattern.length();

        for (int i = patternLen + 1; i < n; i++) { // Start from after the delimiter
            if (Z[i] == patternLen) { // If Z[i] equals the pattern length, we found a match
                result.add(i - patternLen - 1); // Add the starting index in the original text
            }
        }

        return result;
    }

    // Helper function to compute the Z-array for a given string
    // Z[0] is not defined (usually 0), Z[i] = length of longest common prefix between the string and its suffix starting at i
    private int[] computeZArray(String s) {
        int n = s.length();
        int[] Z = new int[n];
        int left = 0;
        int right = 0;

        for (int i = 1; i < n; i++) {
            if (i <= right) {
                // If i is within the Z-box, use previously computed values
                Z[i] = Math.min(right - i + 1, Z[i - left]);
            }

            // Expand the Z-box by comparing characters
            while (i + Z[i] < n && s.charAt(Z[i]) == s.charAt(i + Z[i])) {
                Z[i]++;
            }

            // Update the Z-box boundaries if we expanded beyond the current right boundary
            if (i + Z[i] - 1 > right) {
                left = i;
                right = i + Z[i] - 1;
            }
        }

        return Z;
    }

}
