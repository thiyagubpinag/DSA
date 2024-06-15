package array;

import java.util.Stack;

public class RemoveKdigits {
    public static String removeKdigits(String num, int k) {
        //Write your code here
        Stack<Integer> stack=new Stack();

        for(int i=0;i<num.length();i++){
            int i1 = Integer.parseInt(String.valueOf(num.charAt(i)));
            while(k>0 && !stack.isEmpty() && stack.peek()>= i1){
                stack.pop();
                k--;
            }
            stack.push(i1);
        }

        int res=1;
        int total=0;
        while(!stack.isEmpty()){
            total+=(res*stack.pop());
            res*=10;
        }

        return String.valueOf(total);


    }

    public static void main(String[] args) {
        String a="10200" ;
        int k=1;
          String res=removeKdigits(a,k);
        System.out.println(res);
    }
}
