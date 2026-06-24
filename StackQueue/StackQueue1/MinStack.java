package StackQueue.StackQueue1;

import java.util.Stack;

public class MinStack {

    // MinStack that supports push, pop, top, and getMin
    // all in O(1) time.
    //
    // Approach: We use two stacks: one for values and one for
    // minimums. The minStack stores the minimum value seen so
    // far at each level. When we push, we push the minimum of
    // the new value and the current minimum onto minStack.

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("Min: " + minStack.getMin()); // -3
        minStack.pop();
        System.out.println("Top: " + minStack.top());    // 0
        System.out.println("Min: " + minStack.getMin()); // -2
    }

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    // Push an element onto the stack
    public void push(int val) {
        stack.push(val);
        // Push the new minimum onto minStack
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            minStack.push(Math.min(val, minStack.peek()));
        }
    }

    // Remove the top element
    public void pop() {
        stack.pop();
        minStack.pop();
    }

    // Return the top element without removing it
    public int top() {
        return stack.peek();
    }

    // Return the minimum element in the stack
    public int getMin() {
        return minStack.peek();
    }

}
