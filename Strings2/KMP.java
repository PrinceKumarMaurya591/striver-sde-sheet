package Strings2;

import java.util.ArrayList;
import java.util.List;

public class KMP {

    public static void main(String[] args) {
        KMP kmp = new KMP();
        String text = "abcabcdabc";
        String pattern = "abc";
        List<Integer> result = kmp.search(text, pattern);
        System.out.println(result); // Output: [0, 3, 6]
    }

    // Function to find all occurrences of a pattern in a text using the KMP algorithm
    // The function takes a text string and a pattern string as input and returns a list of starting indices where the pattern is found in the text
    // The function uses the Knuth-Morris-Pratt (KMP) algorithm to solve the problem
    // The time complexity of the function is O(n + m), where n is the length of the text and m is the length of the pattern. The space complexity is O(m) for the LPS array.

    // Approach: Preprocess the pattern to compute the LPS (Longest Proper Prefix which is also Suffix) array.
    // The LPS array tells us, when a mismatch occurs, how many characters we can skip in the pattern.
    // Use two pointers: i for the text and j for the pattern.
    // When characters match, increment both pointers.
    // When there is a mismatch, set j to LPS[j-1] (if j > 0), or move i forward (if j == 0).
    // When j reaches the pattern length, we found a match. Record the index and set j to LPS[j-1].
    public List<Integer> search(String text, String pattern) {
        List<Integer> result = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();

        if (m == 0) { // If the pattern is empty, return an empty list
            return result;
        }

        int[] lps = computeLPS(pattern); // Compute the LPS array for the pattern

        int i = 0; // Pointer for the text
        int j = 0; // Pointer for the pattern

        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) { // If characters match, move both pointers forward
                i++;
                j++;

                if (j == m) { // If we have matched the entire pattern, we found a match
                    result.add(i - j); // Record the starting index
                    j = lps[j - 1]; // Continue searching for more matches
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1]; // Use the LPS array to skip characters in the pattern
                } else {
                    i++; // If j is 0, move the text pointer forward
                }
            }
        }

        return result;
    }

    // Helper function to compute the LPS (Longest Proper Prefix which is also Suffix) array
    // LPS[i] = length of the longest proper prefix of pattern[0..i] which is also a suffix of pattern[0..i]
    private int[] computeLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int length = 0; // Length of the previous longest prefix suffix
        int i = 1;

        lps[0] = 0; // LPS[0] is always 0 since a single character has no proper prefix

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(length)) { // If characters match, extend the prefix
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1]; // Try a shorter prefix
                } else {
                    lps[i] = 0; // No matching prefix found
                    i++;
                }
            }
        }

        return lps;
    }

}
