package Array3;

public class PowXN {

    public static void main(String[] args) {
        PowXN pxn = new PowXN();
        double x = 2.0;
        int n = 10;
        System.out.println(pxn.myPow(x, n)); // Output: 1024.0
    }

    // Function to calculate x raised to the power n (x^n)
    // The function takes a double x and an integer n as input and returns x^n as a double
    // The function uses a binary exponentiation (fast exponentiation) approach to solve the problem
    // The time complexity of the function is O(log n), where n is the exponent. The space complexity is O(1) as we are using a constant amount of extra space.

    // Approach: Handle the case where n is negative by converting x to 1/x and n to -n.
    // Use binary exponentiation: keep squaring x and dividing n by 2.
    // If n is odd, multiply the result by the current value of x.
    // Continue until n becomes 0.
    public double myPow(double x, int n) {
        // If n is negative, convert the problem to positive exponent by taking reciprocal
        long N = n; // Use long to handle Integer.MIN_VALUE case (negating -2147483648 would overflow int)
        if (N < 0) {
            x = 1 / x; // Take reciprocal of x
            N = -N; // Make exponent positive
        }

        double result = 1.0;
        double currentProduct = x;

        while (N > 0) {
            if ((N & 1) == 1) { // If the current bit of N is 1 (i.e., N is odd), multiply result by currentProduct
                result *= currentProduct;
            }
            currentProduct *= currentProduct; // Square the current product for the next bit
            N >>= 1; // Right shift N by 1 to process the next bit (equivalent to N /= 2)
        }

        return result;
    }

}
