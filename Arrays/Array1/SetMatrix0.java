package Array1;

public class SetMatrix0 {
    
 public static void main(String[] args) {
    
        SetMatrix0 sm = new SetMatrix0();
        int[][] matrix = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };
        sm.setZeroes(matrix);
        // Output the modified matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Function to set entire row and column to zero if an element is zero
    // The function takes a 2D array (matrix) as input and modifies it in place
    // The function uses a greedy approach to solve the problem by first identifying the rows and columns that need to be set to zero and then updating the matrix accordingly
    // The time complexity of the function is O(m * n), where m is the number of rows and n is the number of columns in the matrix. The space complexity is O(1) as we are using a constant amount of extra space.


//Approach: Use the first row and first column of the matrix to mark the rows and columns that need to be set to zero.
// First, we check if the first row and first column have any zeros. 
// If they do, we set flags to indicate that we need to set the entire first row or first column to zero later.
// Next, we iterate through the rest of the matrix and mark the corresponding first row and first column elements as zero if we encounter a zero in the matrix.
// Finally, we iterate through the matrix again and set the elements to zero based on the marks in the first row and first column.

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;

        // Check if the first row has any zeros
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowHasZero = true;
                break;  // Exit the loop early if a zero is found because we only need to know if there is at least one zero in the first row
            }
        }

        // Check if the first column has any zeros
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }

        // Use the first row and column to mark zeros
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) { // If an element is zero, mark the corresponding first row and first column elements as zero
                    matrix[i][0] = 0; // Mark the first element of the row zero
                    matrix[0][j] = 0; // Mark the first element of the column zero
                }
            }
        }

        // Set zeros based on marks in the first row and column
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) { // If either the first element of the row or the first element of the column is zero, set the current element to zero
                    matrix[i][j] = 0;  // Set the current element to zero
                }
            }
        }

        // Set zeros in the first row and column if needed
        if (firstRowHasZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        if (firstColHasZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

}
