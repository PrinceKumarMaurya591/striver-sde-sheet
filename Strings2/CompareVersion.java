package Strings2;

public class CompareVersion {

    public static void main(String[] args) {
        CompareVersion cv = new CompareVersion();
        String version1 = "1.01";
        String version2 = "1.001";
        System.out.println(cv.compareVersion(version1, version2)); // Output: 0 (equal)
    }

    // Function to compare two version numbers
    // The function takes two version strings as input and returns:
    // -1 if version1 < version2, 0 if equal, 1 if version1 > version2
    // The function uses a two-pointer approach to solve the problem
    // The time complexity of the function is O(n + m), where n and m are the lengths of the two version strings. The space complexity is O(1) as we are using a constant amount of extra space.

    // Approach: Use two pointers to iterate through both version strings simultaneously.
    // For each segment (separated by dots), parse the integer value (ignoring leading zeros).
    // Compare the two segment values. If one is less than the other, return -1 or 1 accordingly.
    // If all segments are equal, return 0.
    public int compareVersion(String version1, String version2) {
        int i = 0; // Pointer for version1
        int j = 0; // Pointer for version2
        int n = version1.length();
        int m = version2.length();

        while (i < n || j < m) {
            int num1 = 0; // Current segment value for version1
            int num2 = 0; // Current segment value for version2

            // Parse the next segment from version1 (characters until the next dot or end of string)
            while (i < n && version1.charAt(i) != '.') {
                num1 = num1 * 10 + (version1.charAt(i) - '0'); // Build the number digit by digit
                i++;
            }

            // Parse the next segment from version2
            while (j < m && version2.charAt(j) != '.') {
                num2 = num2 * 10 + (version2.charAt(j) - '0');
                j++;
            }

            // Compare the current segments
            if (num1 < num2) {
                return -1; // version1 is less than version2
            } else if (num1 > num2) {
                return 1; // version1 is greater than version2
            }

            // Skip the dot to move to the next segment
            i++;
            j++;
        }

        return 0; // All segments are equal
    }

}
