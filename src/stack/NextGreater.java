package stack;

import java.util.Stack;

public class NextGreater {
    public static void main(String[] args) {
        int[] a = {-3, 6, 7, 2, 1, 8, 5, 9};

        int[] ng = new int[a.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = a.length - 1; i >= 0; i--) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && a[stack.peek()] < a[i]) {
                    stack.pop();
                }
            }
            ng[i] = stack.isEmpty() ? -1 : a[stack.peek()];
            stack.push(i);
        }

        for(int i=0;i<ng.length;i++)
            System.out.print(ng[i]);

    }
}
