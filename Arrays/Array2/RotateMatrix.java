package Array2;

public class RotateMatrix {

    public static void main(String[] args) {
        RotateMatrix rm = new RotateMatrix();
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        rm.rotate(matrix);
        // Output the modified matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Function to rotate a matrix by 90 degrees clockwise
    // The function takes a 2D array (matrix) as input and modifies it in place
    // The function uses a two-step approach: first transpose the matrix, then reverse each row
    // The time complexity of the function is O(n^2), where n is the number of rows/columns in the matrix. The space complexity is O(1) as we are using a constant amount of extra space.

    // Approach: First, we transpose the matrix by swapping elements across the diagonal.
    // Then, we reverse each row of the transposed matrix to get the final rotated matrix.
    // Transpose converts rows to columns, and reversing each row gives a 90-degree clockwise rotation.
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose the matrix (swap matrix[i][j] with matrix[j][i])
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) { // Start from i+1 to avoid swapping diagonal elements and double swapping
                // Swap elements across the diagonal
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row of the transposed matrix
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            while (left < right) { // Reverse the row by swapping elements from both ends
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }

}
