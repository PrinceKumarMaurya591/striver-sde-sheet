package BinarySearch;

public class NthRoot {

    public static void main(String[] args) {
        NthRoot nr = new NthRoot();
        int n = 3;
        int m = 27;
        System.out.println(nr.nthRoot(n, m)); // Output: 3 (since 3^3 = 27)
    }

    // Function to find the integer nth root of a number m (largest integer x such that x^n <= m)
    // The function takes two integers n and m as input and returns the integer nth root
    // The function uses a binary search approach to solve the problem
    // The time complexity of the function is O(log m * n), where log m is the number of binary search iterations and n is the exponent. The space complexity is O(1) as we are using a constant amount of extra space.

    // Approach: The nth root lies between 1 and m.
    // Use binary search to find the largest integer x such that x^n <= m.
    // For each mid value, compute mid^n and compare with m.
    // If mid^n <= m, move left = mid + 1 (try a larger value). Otherwise, move right = mid - 1.
    public int nthRoot(int n, int m) {
        int low = 1;
        int high = m;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            long power = power(mid, n); // Compute mid^n

            if (power == m) { // Exact root found
                return mid;
            } else if (power < m) {
                result = mid; // mid is a possible answer, try a larger value
                low = mid + 1;
            } else {
                high = mid - 1; // mid is too large, try a smaller value
            }
        }

        return result; // Return the floor of the nth root
    }

    // Helper function to compute x^n (without overflow by using long)
    private long power(int x, int n) {
        long result = 1;
        for (int i = 0; i < n; i++) {
            result *= x;
            if (result > Integer.MAX_VALUE) { // Early exit if result exceeds the range
                return Integer.MAX_VALUE + 1L; // Return a value larger than any possible m
            }
        }
        return result;
    }

}
