package stack;

import java.util.Stack;

public class LargestRectangle {
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack();
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                left[i] = 0;
            } else {
                left[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                right[i] = n - 1;
            } else {
                right[i] = stack.peek();
            }
            stack.push(i);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int i1 = right[i] - left[i] - 1;
            int value = heights[i] * (i1 == 0 ? 1 : i1);
            max = Math.max(max, value);
        }
        return max;
    }

    public static void main(String[] args) {
        largestRectangleArea(new int[]{2,1,5,6,2,3});
    }
}
