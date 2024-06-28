package array;

import java.util.Stack;

public class StockProblem {
    public static void main(String[] args) {
        int[] arr={100, 80, 60, 70, 60, 75, 85};
        Stack<Integer> stack=new Stack<>();
        int[] res=new int[arr.length];

        for(int i=0;i<arr.length;i++){
            if(!stack.empty()){
                while(!stack.isEmpty() && arr[stack.peek()]<arr[i]){
                    stack.pop();
                }
            }
            if(stack.empty()){
                res[i]=1;
            }else{
                res[i]=i-stack.peek();
            }
            stack.push(i);
        }

        System.out.println(stack);

    }
}
