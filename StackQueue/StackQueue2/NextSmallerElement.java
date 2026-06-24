package StackQueue.StackQueue2;

import java.util.Stack;

public class NextSmallerElement {

    public static void main(String[] args) {
        NextSmallerElement nse = new NextSmallerElement();
        int[] nums = {4, 5, 2, 25};
        int[] result = nse.nextSmallerElements(nums);
        System.out.print("Next smaller elements: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    // Function to find the next smaller element for each element
    // in an array. The next smaller element is the first smaller
    // element to the right. If none exists, return -1.
    // Time complexity: O(n), Space complexity: O(n).

    // Approach: We use a monotonic increasing stack. We iterate
    // from right to left. For each element, we pop elements from
    // the stack that are greater or equal. The top of the stack
    // after popping is the next smaller element.
    public int[] nextSmallerElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= nums[i]) {
                stack.pop();
            }

            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }

        return result;
    }

}
