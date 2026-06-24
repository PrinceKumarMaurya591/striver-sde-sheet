package StackQueue.StackQueue1;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        String s = "()[]{}";
        System.out.println("Is valid: " + vp.isValid(s));
    }

    // Function to check if a string of brackets is valid.
    // A string is valid if every opening bracket has a
    // matching closing bracket in the correct order.
    // Time complexity: O(n), Space complexity: O(n).

    // Approach: We use a stack. When we see an opening bracket,
    // we push it onto the stack. When we see a closing bracket,
    // we check if the top of the stack is the matching opening
    // bracket. If not, the string is invalid.
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;

                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

}
