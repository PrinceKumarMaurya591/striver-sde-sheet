package DP.DP1;

public class Fibonacci {

    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
        int n = 10;
        int result = fib.fib(n);
        System.out.println("Fibonacci(" + n + ") = " + result);
    }

    // Function to compute the Nth Fibonacci number using DP.
    // Time complexity: O(n), Space complexity: O(1).

    // Approach: Use bottom-up DP with two variables. Start with
    // a=0, b=1. For each step, compute next = a + b, then shift
    // a = b, b = next. Repeat n times.
    public int fib(int n) {
        if (n <= 1) return n;

        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int next = a + b;
            a = b;
            b = next;
        }
        return b;
    }

}
