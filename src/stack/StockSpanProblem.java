package stack;

import java.util.ArrayList;
import java.util.Stack;

public class StockSpanProblem {
    public static void main(String[] args) {
        int[] arr = {100, 80, 60, 70, 60, 75, 85};

        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                temp.add(-1);
            } else {
                temp.add(stack.peek());
            }
            stack.push(i);
        }
        for (int i = 0; i < temp.size(); i++) {
            res.add(i - temp.get(i));
        }
        temp.forEach(i -> System.out.print(i + " "));
        System.out.println();
        res.forEach(i -> System.out.print(i + " "));

    }
}
