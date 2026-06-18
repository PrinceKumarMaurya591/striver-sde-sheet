package Strings2;

public class MinCharsForPalindrome {

    public static void main(String[] args) {
        MinCharsForPalindrome mcp = new MinCharsForPalindrome();
        String s = "AACECAAAA";
        System.out.println(mcp.minChars(s)); // Output: 2 (add "AA" at the beginning to make it "AAAACECAAAA")
    }

    // Function to find the minimum number of characters to add at the beginning of a string to make it a palindrome
    // The function takes a string as input and returns the minimum number of characters to add
    // The function uses the LPS array from KMP algorithm to solve the problem efficiently
    // The time complexity of the function is O(n), where n is the length of the string. The space complexity is O(n) for the LPS array.

    // Approach: Create a concatenated string: s + "$" + reverse(s).
    // Compute the LPS array for this concatenated string.
    // The last value in the LPS array gives the length of the longest prefix of s that is also a suffix of reverse(s).
    // This is the length of the longest palindromic prefix of s.
    // The answer is n - LPS[last], which is the number of characters to add at the beginning.
    public int minChars(String s) {
        String reversed = new StringBuilder(s).reverse().toString(); // Reverse the string
        String concat = s + "$" + reversed; // Concatenate s + delimiter + reversed s

        int[] lps = computeLPS(concat); // Compute LPS array for the concatenated string
        int longestPalindromicPrefix = lps[concat.length() - 1]; // The last value gives the longest palindromic prefix

        return s.length() - longestPalindromicPrefix; // Characters to add = total length - longest palindromic prefix
    }

    // Helper function to compute the LPS array (same as KMP)
    private int[] computeLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int length = 0;
        int i = 1;

        lps[0] = 0;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

}
