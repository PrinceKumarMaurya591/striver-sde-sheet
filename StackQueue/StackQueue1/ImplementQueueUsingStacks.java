package StackQueue.StackQueue1;

import java.util.Stack;

public class ImplementQueueUsingStacks {

    // Queue implementation using two stacks.
    // All operations are amortized O(1).
    //
    // Approach: We use two stacks: input and output.
    // For push: push to input stack.
    // For pop/peek: if output is empty, transfer all
    // elements from input to output (reversing order),
    // then pop/peek from output.

    private Stack<Integer> input;
    private Stack<Integer> output;

    public static void main(String[] args) {
        ImplementQueueUsingStacks queue =
                new ImplementQueueUsingStacks();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println("Pop: " + queue.pop());    // 1
        System.out.println("Peek: " + queue.peek());  // 2
        System.out.println("Pop: " + queue.pop());    // 2
        System.out.println("Empty: " + queue.empty());// false
    }

    public ImplementQueueUsingStacks() {
        input = new Stack<>();
        output = new Stack<>();
    }

    // Push element to the back of the queue
    public void push(int x) {
        input.push(x);
    }

    // Remove and return the front element
    public int pop() {
        if (output.isEmpty()) {
            transfer();
        }
        return output.pop();
    }

    // Return the front element without removing it
    public int peek() {
        if (output.isEmpty()) {
            transfer();
        }
        return output.peek();
    }

    // Check if the queue is empty
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }

    private void transfer() {
        while (!input.isEmpty()) {
            output.push(input.pop());
        }
    }

}
