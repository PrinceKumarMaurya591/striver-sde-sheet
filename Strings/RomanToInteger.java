package Strings;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        RomanToInteger ri = new RomanToInteger();
        String s = "MCMXCIV";
        System.out.println(ri.romanToInt(s)); // Output: 1994
    }

    // Function to convert a Roman numeral string to an integer
    // The function takes a string representing a Roman numeral as input and returns its integer value
    // The function uses a greedy approach with a hashmap to solve the problem
    // The time complexity of the function is O(n), where n is the length of the string. The space complexity is O(1) for the hashmap of 7 entries.

    // Approach: Create a hashmap mapping Roman characters to their integer values.
    // Iterate through the string from left to right.
    // If the current character's value is less than the next character's value, it means we have a subtractive combination (like IV = 4), so subtract the current value.
    // Otherwise, add the current value to the result.
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int currentValue = map.get(s.charAt(i)); // Get the value of the current Roman character

            if (i < n - 1 && currentValue < map.get(s.charAt(i + 1))) {
                // If the current value is less than the next value, subtract it (e.g., IV, IX, XL, XC, CD, CM)
                result -= currentValue;
            } else {
                // Otherwise, add it to the result
                result += currentValue;
            }
        }

        return result;
    }

}
