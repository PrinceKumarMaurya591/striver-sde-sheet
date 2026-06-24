package StackQueue.StackQueue1;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {

    // Stack implementation using a single queue.
    // Time complexity: O(n) for push, O(1) for pop/peek.
    //
    // Approach: We use one queue. For push, we add the new
    // element and then rotate all previous elements behind it,
    // so the newest element is always at the front of the queue.

    private Queue<Integer> queue;

    public static void main(String[] args) {
        ImplementStackUsingQueues stack =
                new ImplementStackUsingQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Top: " + stack.top());    // 3
        System.out.println("Pop: " + stack.pop());    // 3
        System.out.println("Top: " + stack.top());    // 2
        System.out.println("Empty: " + stack.empty());// false
    }

    public ImplementStackUsingQueues() {
        queue = new LinkedList<>();
    }

    // Push element onto the stack
    public void push(int x) {
        queue.offer(x);
        // Rotate the queue so the new element is at the front
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            queue.offer(queue.poll());
        }
    }

    // Remove and return the top element
    public int pop() {
        return queue.poll();
    }

    // Return the top element without removing it
    public int top() {
        return queue.peek();
    }

    // Check if the stack is empty
    public boolean empty() {
        return queue.isEmpty();
    }

}
