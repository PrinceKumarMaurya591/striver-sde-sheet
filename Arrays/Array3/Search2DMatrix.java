package Array3;

public class Search2DMatrix {

    public static void main(String[] args) {
        Search2DMatrix sm = new Search2DMatrix();
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        int target = 3;
        System.out.println(sm.searchMatrix(matrix, target)); // Output: true
    }

    // Function to search for a target value in a 2D matrix
    // The function takes a 2D array (matrix) and an integer target as input and returns a boolean indicating whether the target is present in the matrix
    // The matrix has the property that each row is sorted in ascending order and the first element of each row is greater than the last element of the previous row
    // The function uses a binary search approach to solve the problem by treating the matrix as a flattened sorted array
    // The time complexity of the function is O(log(m * n)), where m is the number of rows and n is the number of columns. The space complexity is O(1) as we are using a constant amount of extra space.

    // Approach: Treat the 2D matrix as a 1D sorted array of length m * n.
    // Use binary search on the flattened array. Map the mid index to the corresponding row and column using:
    // row = mid / n, col = mid % n
    // Compare the element at this position with the target and adjust the search range accordingly.
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1; // Treat the matrix as a flattened array from 0 to m*n-1

        while (left <= right) {
            int mid = left + (right - left) / 2; // Find the middle index
            int row = mid / n; // Map mid to row index
            int col = mid % n; // Map mid to column index
            int midValue = matrix[row][col];

            if (midValue == target) { // If the mid element is the target, return true
                return true;
            } else if (midValue < target) { // If the mid element is less than the target, search the right half
                left = mid + 1;
            } else { // If the mid element is greater than the target, search the left half
                right = mid - 1;
            }
        }

        return false; // Target not found
    }

}
