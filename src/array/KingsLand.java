package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class KingsLand {
    public static void kingsLand(List<Integer> landValues) {
        // Write your code here
        Stack<Integer> stack = new Stack();
        int n = landValues.size();
        ArrayList<Integer> left = new ArrayList();
        int[] leftSum = new int[n];
        ArrayList<Integer> right = new ArrayList();

        for (int i = 0; i < n; i++) {
            leftSum[i] = i == 0 ? landValues.getFirst() : landValues.get(i) + leftSum[i - 1];
            while (!stack.isEmpty() && landValues.get(stack.peek()) < landValues.get(i)) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                left.add(0);
            } else {
                left.add(stack.peek() + 1);
            }
            stack.push(i);
        }
        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && landValues.get(stack.peek()) < landValues.get(i)) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                right.add(n - 1);
            } else {
                right.add(stack.peek() - 1);
            }
            stack.push(i);
        }

        Collections.reverse(right);
        int[] kingsLand=new int[n];
        for(int i=0;i<n;i++){
            int leftValue=left.get(i);
            if(leftValue==0){
                kingsLand[i]=leftSum[right.get(i)];
            }else{
                kingsLand[i]=leftSum[right.get(i)]-leftSum[left.get(i)-1];
            }
            System.out.print(kingsLand[i]+" ");
        }

    }

    public static void main(String[] args) {
        kingsLand(List.of(6, 2, 3, 14, 5));
    }
}
