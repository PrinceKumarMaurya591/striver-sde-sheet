package Strings;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        String s = "babad";
        System.out.println(lps.longestPalindrome(s)); // Output: "bab" or "aba"
    }

    // Function to find the longest palindromic substring in a given string
    // The function takes a string as input and returns the longest palindromic substring
    // The function uses an expand-around-center approach to solve the problem
    // The time complexity of the function is O(n^2), where n is the length of the string. The space complexity is O(1) as we are using a constant amount of extra space.

    // Approach: There are 2n - 1 possible centers for palindromes (n single characters and n-1 gaps between characters).
    // For each center, expand outward while the characters on both sides match.
    // Keep track of the start and end indices of the longest palindrome found so far.
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) { // If the string is empty or null, return an empty string
            return "";
        }

        int start = 0; // Start index of the longest palindrome
        int end = 0; // End index of the longest palindrome

        for (int i = 0; i < s.length(); i++) {
            // Expand around center for odd-length palindrome (center is a single character)
            int len1 = expandAroundCenter(s, i, i);
            // Expand around center for even-length palindrome (center is between two characters)
            int len2 = expandAroundCenter(s, i, i + 1);

            int len = Math.max(len1, len2); // Take the longer palindrome length

            if (len > end - start) { // If this palindrome is longer than the previous longest, update start and end
                start = i - (len - 1) / 2; // Calculate the start index of the palindrome
                end = i + len / 2; // Calculate the end index of the palindrome
            }
        }

        return s.substring(start, end + 1); // Return the longest palindromic substring
    }

    // Helper function to expand around a center and return the length of the palindrome
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--; // Move left pointer outward
            right++; // Move right pointer outward
        }
        return right - left - 1; // Return the length of the palindrome (right - left + 1 - 2 = right - left - 1)
    }

}
