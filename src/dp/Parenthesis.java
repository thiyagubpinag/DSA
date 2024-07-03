package dp;

import java.util.Stack;

public class Parenthesis {
    static int count = 0;

    static void _printParenthesis(char str[], int pos, int n, int open, int close) {
        if (close == n) {
            // print the possible combinations
            for (int i = 0; i < str.length; i++)
                System.out.print(str[i]);
            System.out.println();
            return;
        } else {
            if (open > close) {
                str[pos] = '}';
                _printParenthesis(str, pos + 1, n, open, close + 1);
            }
            if (open < n) {
                str[pos] = '{';
                _printParenthesis(str, pos + 1, n, open + 1, close);
            }
        }
    }

    // Wrapper over _printParenthesis()
    static void printParenthesis(char str[], int n) {
        if (n > 0) _printParenthesis(str, 0, n, 0, 0);
        return;
    }

    // driver program
    public static void main(String[] args) {
        int n = 2;
        char[] str = new char[2 * n];
        printParenthesis(str, n);

        Stack<Character> stack = new Stack<Character>();
        int res = generateParanthesis(0, 0, n, stack);
        System.out.println(res);
    }

    private static int generateParanthesis(int open, int close, int n, Stack<Character> stack) {
        if (close == n) {
            count++;
        }
        if (open < n) {
            stack.add('(');
            generateParanthesis(open + 1, close, n, stack);
            stack.pop();
        }
        if (close < open) {
            stack.add(')');
            generateParanthesis(open, close + 1, n, stack);
            stack.pop();
        }
        return count;
    }

}
