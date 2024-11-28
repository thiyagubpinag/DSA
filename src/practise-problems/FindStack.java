package test;

import java.util.Stack;

public class FindStack {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack();
        int index = 0;
        for (int i = 0; i < popped.length; i++) {
            boolean found = false;
            while (index < pushed.length) {
                if (!stack.isEmpty() && stack.peek() == popped[i]) {
                    found = true;
                    break;
                }
                stack.push(pushed[index++]);
            }
            if (found) {
                stack.pop();
            } else {
                if (index == pushed.length) {
                    if (!stack.isEmpty() && stack.peek() == popped[i]) {
                        stack.pop();
                    }
                }
            }

        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5}, popped = {4, 5, 3, 1, 2};
        validateStackSequences(pushed, popped);
    }
}
