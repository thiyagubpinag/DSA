package array;

import java.util.HashSet;
import java.util.Objects;
import java.util.Stack;

public class Calculator {
    public static int evaluate(String expression) throws Exception {
        Stack<Integer> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();
        int num = 0;

        for (char ch : expression.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0'); // Efficient number building
            } else if (isOperator(ch)) {
                numbers.push(num);
                operators.push(ch);
                num = 0;
            } else if (ch == '(') {
                operators.push(ch);
            } else if (ch == ')') {
                int temp = 0;
                while (!operators.isEmpty() && operators.peek() != '(') {
                    char op2 = operators.pop();
                    int op1 = numbers.pop();
                    temp = calculate(op1, op2, temp);
                }
                operators.pop(); // Remove the '('
                numbers.push(temp);
            } else if (Character.isSpaceChar(ch)) {
                // Ignore spaces
            } else {
                throw new Exception("Invalid character in expression: " + ch);
            }
        }

        // Handle remaining elements after processing the entire string
        if (numbers.size() == 1) {
            return numbers.pop();
        } else {
            throw new Exception("Incomplete or invalid expression");
        }
    }

    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private static int calculate(int op1, char op, int op2) throws Exception {
        switch (op) {
            case '+':
                return op1 + op2;
            case '-':
                return op1 - op2;
            case '*':
                return op1 * op2;
            case '/':
                if (op2 == 0) {
                    throw new Exception("Division by zero");
                }
                return op1 / op2;
            default:
                throw new Exception("Invalid operator: " + op);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(evaluate("(1+(4+5+2)-3)+(6+8)"));
    }
}
