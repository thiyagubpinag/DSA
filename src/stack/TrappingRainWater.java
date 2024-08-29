package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 3, 7, 9};

        Stack<Integer> stack = new Stack<>();

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                left.add(0);
            } else {
                left.add(stack.peek()+1);
            }
            stack.push(i);
        }

        stack.clear();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                right.add(arr.length-1);
            } else {
                right.add(stack.peek()-1);
            }
            stack.push(i);
        }

        List<Integer> reverse=right.reversed();

        for(int i=0;i< arr.length;i++){
            int diff=reverse.get(i)-left.get(i)+1;
            System.out.println(arr[i]*diff);
        }

    }
}
