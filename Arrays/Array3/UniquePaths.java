package Array3;

public class UniquePaths {

    public static void main(String[] args) {
        UniquePaths up = new UniquePaths();
        int m = 3, n = 7;
        System.out.println(up.uniquePaths(m, n)); // Output: 28
    }

    // Function to find the number of unique paths from the top-left corner to the bottom-right corner of a grid
    // The function takes two integers m and n representing the number of rows and columns of the grid as input and returns the number of unique paths
    // The function uses a combinatorial mathematics approach to solve the problem
    // The time complexity of the function is O(min(m, n)) or O(m + n) for the calculation. The space complexity is O(1) as we are using a constant amount of extra space.

    // Approach: The robot needs to make (m - 1) down moves and (n - 1) right moves, totaling (m + n - 2) moves.
    // The number of unique paths is the number of ways to choose (m - 1) down moves (or (n - 1) right moves) from the total moves.
    // This is a combination problem: C(m + n - 2, m - 1) or C(m + n - 2, n - 1).
    // Use the smaller of (m - 1) and (n - 1) for efficient calculation to avoid overflow.
    public int uniquePaths(int m, int n) {
        // Total moves needed = (m - 1) down + (n - 1) right = (m + n - 2)
        int totalMoves = m + n - 2;
        int choose = Math.min(m - 1, n - 1); // Choose the smaller value for efficient computation

        // Calculate C(totalMoves, choose) = totalMoves! / (choose! * (totalMoves - choose)!)
        long result = 1; // Use long to avoid overflow during intermediate calculations
        for (int i = 1; i <= choose; i++) {
            // Multiply by (totalMoves - choose + i) and divide by i incrementally
            result = result * (totalMoves - choose + i) / i;
        }

        return (int) result;
    }

}
