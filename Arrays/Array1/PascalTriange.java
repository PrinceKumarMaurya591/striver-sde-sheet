package Array1;

import java.util.ArrayList;
import java.util.List;

public class PascalTriange {
    

    public static void main(String[] args) {
        PascalTriange pt = new PascalTriange();
        int numRows = 5;
        System.out.println(pt.generate(numRows));
    }

    // Function to generate the first numRows of Pascal's triangle
    // The function takes an integer numRows as input and returns a list of lists representing the rows of Pascal's triangle
    // The function uses a greedy approach to build each row based on the previous row
    // The time complexity of the function is O(numRows^2) because we are generating numRows rows and each row can have up to numRows elements. 
    // The space complexity is also O(numRows^2) because we are storing all the rows in a list of lists.

    // Approach: We iterate from 0 to numRows - 1 to generate each row of Pascal's triangle.
    // For each row, we create a new list and fill it with the appropriate values.
    // The first and last element of each row is always 1. For the inner elements
    // we calculate the value as the sum of the two elements directly above it in the previous row.


    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();// Create a new list for the current row because we need to store the values of the current row separately from the previous row
            for (int j = 0; j <= i; j++) { // We iterate from 0 to i to fill the current row because the number of elements in the current row is equal to the row index + 1
                if (j == 0 || j == i) { // The first and last element of each row is always 1
                    row.add(1);
                } else { // Each inner element is the sum of the two elements directly above it in the previous row
                    int val = triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j);
                    row.add(val);
                }
            }
            triangle.add(row); // Add the current row to the triangle
        }

        return triangle;
    }

}
