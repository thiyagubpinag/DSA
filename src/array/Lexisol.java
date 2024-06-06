package array;

import java.util.Stack;

public class Lexisol {
    public static int solve(int n, String s) {
        //Write your code here;

        int right = 0;
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        while (right < n) {
            if (!(!stack.isEmpty() && stack.peek() > charArray[right])) {
                stack.push(charArray[right]);
            }
            right++;
        }

        return stack.size();

    }

    public static int solveQues(int n, String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.empty() && s.charAt(i) > st.peek())
                st.pop();
            st.push(s.charAt(i));
        }
        StringBuilder res = new StringBuilder();
        while (!st.empty()) {
            res.append(st.peek());
            st.pop();
        }
        return res.length();

    }

    public static void main(String[] args) {
        String s = "dhananjaya";
        System.out.println(solveQues(s.length(), s));
    }
}
