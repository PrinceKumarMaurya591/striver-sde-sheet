package StackQueue.StackQueue1;

import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        NextGreaterElement nge = new NextGreaterElement();
        int[] nums = {4, 5, 2, 25};
        int[] result = nge.nextGreaterElements(nums);
        System.out.print("Next greater elements: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    // Function to find the next greater element for each element
    // in an array. The next greater element is the first greater
    // element to the right. If none exists, return -1.
    // Time complexity: O(n), Space complexity: O(n).

    // Approach: We use a monotonic decreasing stack. We iterate
    // from right to left. For each element, we pop elements from
    // the stack that are smaller or equal. The top of the stack
    // after popping is the next greater element. We then push
    // the current element onto the stack.
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            // Pop smaller elements from the stack
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }

            // The top of the stack is the next greater element
            result[i] = stack.isEmpty() ? -1 : stack.peek();

            // Push current element onto the stack
            stack.push(nums[i]);
        }

        return result;
    }

}
