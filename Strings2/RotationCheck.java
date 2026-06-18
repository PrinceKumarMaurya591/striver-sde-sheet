package Strings2;

public class RotationCheck {

    public static void main(String[] args) {
        RotationCheck rc = new RotationCheck();
        String s1 = "abcde";
        String s2 = "cdeab";
        System.out.println(rc.isRotation(s1, s2)); // Output: true
    }

    // Function to check if one string is a rotation of another string
    // The function takes two strings as input and returns a boolean indicating whether one is a rotation of the other
    // The function uses a simple concatenation approach to solve the problem
    // The time complexity of the function is O(n), where n is the length of the strings. The space complexity is O(n) for the concatenated string.

    // Approach: If s2 is a rotation of s1, then s2 must be a substring of s1 + s1.
    // For example, if s1 = "abcde" and s2 = "cdeab", then s1 + s1 = "abcdeabcde" contains s2.
    // First, check if the lengths of both strings are equal and non-zero.
    // Then, check if s2 is a substring of s1 + s1.
    public boolean isRotation(String s1, String s2) {
        // If lengths are different or strings are empty, s2 cannot be a rotation of s1
        if (s1.length() != s2.length() || s1.length() == 0) {
            return false;
        }

        String concatenated = s1 + s1; // Concatenate s1 with itself
        return concatenated.contains(s2); // Check if s2 is a substring of the concatenated string
    }

}
