package Strings;

public class ReverseWords {

    public static void main(String[] args) {
        ReverseWords rw = new ReverseWords();
        String s = "the sky is blue";
        System.out.println(rw.reverseWords(s)); // Output: "blue is sky the"
    }

    // Function to reverse the order of words in a string
    // The function takes a string as input and returns the string with words in reverse order
    // The function uses a two-pointer approach after trimming and cleaning spaces to solve the problem
    // The time complexity of the function is O(n), where n is the length of the string. The space complexity is O(n) for the character array.

    // Approach: Convert the string to a character array and reverse the entire string.
    // Then, reverse each individual word to restore the correct order of characters within each word.
    // Finally, clean up extra spaces (leading, trailing, and multiple spaces between words).
    public String reverseWords(String s) {
        // Convert string to character array for in-place manipulation
        char[] chars = s.toCharArray();
        int n = chars.length;

        // Step 1: Reverse the entire string
        reverse(chars, 0, n - 1);

        // Step 2: Reverse each individual word
        int start = 0;
        for (int end = 0; end < n; end++) {
            if (chars[end] == ' ') { // If we encounter a space, we've reached the end of a word
                reverse(chars, start, end - 1); // Reverse the current word
                start = end + 1; // Move start to the beginning of the next word
            }
        }
        reverse(chars, start, n - 1); // Reverse the last word

        // Step 3: Clean up extra spaces
        int i = 0; // Pointer for placing characters in the result
        int j = 0; // Pointer for iterating through the array

        while (j < n) {
            // Skip leading spaces
            while (j < n && chars[j] == ' ') {
                j++;
            }
            // Copy the word
            while (j < n && chars[j] != ' ') {
                chars[i++] = chars[j++];
            }
            // Skip trailing spaces after the word
            while (j < n && chars[j] == ' ') {
                j++;
            }
            // If there are more words, add a single space
            if (j < n) {
                chars[i++] = ' ';
            }
        }

        return new String(chars, 0, i); // Return the cleaned string
    }

    // Helper function to reverse a portion of a character array
    private void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

}
