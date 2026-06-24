package StackQueue.StackQueue2;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        LargestRectangleInHistogram lrh =
                new LargestRectangleInHistogram();
        int[] heights = {2, 1, 5, 6, 2, 3};
        int maxArea = lrh.largestRectangleArea(heights);
        System.out.println("Largest rectangle area: " + maxArea);
    }

    // Function to find the largest rectangle area in a histogram.
    // Time complexity: O(n), Space complexity: O(n).

    // Approach: We use a stack to store indices of bars in
    // increasing order of height. When we encounter a bar
    // shorter than the bar at the top of the stack, we pop
    // bars from the stack and calculate the area with the
    // popped bar as the smallest bar. The width extends from
    // the current index to the index of the new top of stack.
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            int currentHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() &&
                    currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i :
                        i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }

}
