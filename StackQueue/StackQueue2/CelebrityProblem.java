package StackQueue.StackQueue2;

import java.util.Stack;

public class CelebrityProblem {

    // Sample knowledge matrix: M[i][j] = 1 means i knows j
    private int[][] matrix;

    public static void main(String[] args) {
        CelebrityProblem cp = new CelebrityProblem();
        // 0 knows 1, 1 knows nobody, 2 knows 1, 3 knows 1
        // All know 1, 1 knows nobody -> 1 is the celebrity
        cp.matrix = new int[][]{
            {0, 1, 0, 0},
            {0, 0, 0, 0},
            {0, 1, 0, 0},
            {0, 1, 0, 0}
        };

        int celebrity = cp.findCelebrity(4);
        System.out.println("Celebrity: " + celebrity);
    }

    // Helper to check if person a knows person b
    private boolean knows(int a, int b) {
        return matrix[a][b] == 1;
    }

    // Function to find the celebrity in a party of n people.
    // A celebrity is someone known by everyone but knows nobody.
    // Time complexity: O(n), Space complexity: O(n).

    // Approach: We use a stack. Push all people onto the stack.
    // While there are at least 2 people, pop two people (a, b).
    // If a knows b, a cannot be a celebrity, push b back.
    // If a doesn't know b, b cannot be a celebrity, push a back.
    // The last remaining person is a potential celebrity.
    // Finally, verify by checking all rows and columns.
    public int findCelebrity(int n) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        // Find the potential celebrity
        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();

            if (knows(a, b)) {
                stack.push(b); // a knows b, so a is not celebrity
            } else {
                stack.push(a); // a doesn't know b, so b is not
            }
        }

        int candidate = stack.pop();

        // Verify the candidate
        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                // Candidate should know nobody
                if (knows(candidate, i)) return -1;
                // Everyone should know candidate
                if (!knows(i, candidate)) return -1;
            }
        }

        return candidate;
    }

}
