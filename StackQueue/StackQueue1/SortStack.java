package StackQueue.StackQueue1;

import java.util.Stack;

public class SortStack {

    public static void main(String[] args) {
        SortStack ss = new SortStack();
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        System.out.println("Original: " + stack);
        ss.sort(stack);
        System.out.println("Sorted: " + stack);
    }

    // Function to sort a stack in ascending order using recursion.
    // The top of the stack will be the smallest element.
    // Time complexity: O(n^2), Space complexity: O(n) for recursion.

    // Approach: We use recursion. First, we pop the top element
    // and recursively sort the remaining stack. Then we insert
    // the popped element in sorted order by using another
    // recursive function that finds the correct position.
    public void sort(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            // Remove the top element
            int top = stack.pop();
            // Recursively sort the remaining stack
            sort(stack);
            // Insert the top element in sorted order
            insertSorted(stack, top);
        }
    }

    private void insertSorted(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
            return;
        }

        int top = stack.pop();
        insertSorted(stack, element);
        stack.push(top);
    }

}
