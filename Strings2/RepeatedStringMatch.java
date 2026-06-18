package Strings2;

public class RepeatedStringMatch {

    public static void main(String[] args) {
        RepeatedStringMatch rsm = new RepeatedStringMatch();
        String a = "abcd";
        String b = "cdabcdab";
        System.out.println(rsm.repeatedStringMatch(a, b)); // Output: 3
    }

    // Function to find the minimum number of times string a must be repeated so that string b becomes a substring of it
    // The function takes two strings a and b as input and returns the minimum number of repetitions needed, or -1 if impossible
    // The function uses a simple concatenation approach with the KMP algorithm to solve the problem
    // The time complexity of the function is O(n + m), where n is the length of the repeated string and m is the length of b. The space complexity is O(m) for the LPS array.

    // Approach: The maximum repetitions needed is at most (len(b) / len(a)) + 2.
    // Keep repeating a until the length of the repeated string is greater than or equal to the length of b.
    // After each repetition, check if b is a substring using the contains() method (or KMP for efficiency).
    // If b is found, return the number of repetitions.
    // If after (len(b) / len(a) + 2) repetitions b is still not found, return -1.
    public int repeatedStringMatch(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();

        // Calculate the minimum number of repetitions needed
        int minRepeats = (int) Math.ceil((double) lenB / lenA);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < minRepeats; i++) {
            sb.append(a); // Repeat a the minimum number of times
        }

        // Check if b is a substring after minRepeats repetitions
        if (sb.toString().contains(b)) {
            return minRepeats;
        }

        // Try one more repetition
        sb.append(a);
        if (sb.toString().contains(b)) {
            return minRepeats + 1;
        }

        return -1; // b is not a substring of any repetition of a
    }

}
