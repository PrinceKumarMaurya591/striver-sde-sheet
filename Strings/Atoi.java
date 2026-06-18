package Strings;

public class Atoi {

    public static void main(String[] args) {
        Atoi atoi = new Atoi();
        String s = "   -42";
        System.out.println(atoi.myAtoi(s)); // Output: -42
    }

    // Function to convert a string to an integer (like the C library atoi)
    // The function takes a string as input and returns the integer value with handling for whitespace, signs, and overflow
    // The function uses a state machine approach with character-by-character parsing to solve the problem
    // The time complexity of the function is O(n), where n is the length of the string. The space complexity is O(1) as we are using a constant amount of extra space.

    // Approach: Skip leading whitespace characters.
    // Check for an optional sign character (+ or -) and store the sign.
    // Iterate through the remaining characters and build the result digit by digit.
    // If a non-digit character is encountered, stop parsing.
    // Handle integer overflow by clamping the result to Integer.MIN_VALUE or Integer.MAX_VALUE.
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int i = 0;
        int n = s.length();
        int sign = 1;
        int result = 0;

        // Step 1: Skip leading whitespace
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Step 2: Check for sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Step 3: Parse digits
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0'; // Convert character to digit

            // Check for overflow before adding the digit
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                // If the result would overflow, return the max or min integer value based on the sign
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit; // Build the result digit by digit
            i++;
        }

        return result * sign; // Apply the sign and return
    }

}
