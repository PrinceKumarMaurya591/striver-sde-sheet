package Strings;

public class IntegerToRoman {

    public static void main(String[] args) {
        IntegerToRoman ir = new IntegerToRoman();
        int num = 1994;
        System.out.println(ir.intToRoman(num)); // Output: "MCMXCIV"
    }

    // Function to convert an integer to a Roman numeral string
    // The function takes an integer as input and returns its Roman numeral representation
    // The function uses a greedy approach to solve the problem
    // The time complexity of the function is O(1) since there are a fixed number of Roman numeral symbols. The space complexity is O(1) for the arrays.

    // Approach: Use two arrays — one for Roman numeral values in descending order and one for the corresponding symbols.
    // For each value-symbol pair, while the input number is greater than or equal to the value,
    // append the symbol to the result and subtract the value from the number.
    // This greedy approach works because the Roman numeral system uses additive and subtractive notation.
    public String intToRoman(int num) {
        // Arrays for Roman numeral values and their corresponding symbols (including subtractive combinations)
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) { // While the number is greater than or equal to the current value
                result.append(symbols[i]); // Append the corresponding symbol
                num -= values[i]; // Subtract the value from the number
            }
        }

        return result.toString();
    }

}
