package Recursion;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class DifferentWaysToAddParentheses {
    private static final char MULTIPLICATION = '*';
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static char[] expressionArr;
    private static String expression;
    private static Set<Character> operatorSet = new HashSet<>();

    public static List<Integer> diffWaysToCompute(String expression1) {
        expression = expression1;
        operatorSet.add(MULTIPLICATION);
        operatorSet.add(ADDITION);
        operatorSet.add(SUBTRACTION);
        expressionArr = expression.toCharArray();
        return dfs(0, expressionArr.length - 1);
    }

    private static List<Integer> dfs(int start, int end) {
        List<Integer> res = new LinkedList<>();
        for (int i = start; i < end; i++) {
            if (operatorSet.contains(expression.charAt(i))) {
                List<Integer> leftList = dfs(start, i - 1);
                List<Integer> rightList = dfs(i + 1, end);
                for (Integer left : leftList) {
                    for (Integer right : rightList) {
                        int val = calculate(left, right, expression.charAt(i));
                        res.add(val);
                    }
                }
            }
        }
        if (res.isEmpty()) {
            res.add(Integer.parseInt(expression.substring(start, end + 1)));
        }
        return res;
    }

    private static Integer calculate(Integer num1, Integer num2, char operator) {
        switch (operator) {
            case MULTIPLICATION:
                return num1 * num2;
            case ADDITION:
                return num1 + num2;
            case SUBTRACTION:
                return num1 - num2;
            default:
                return -1;
        }
    }

    public static void main(String[] args) {
        String s = "2*3-4*5";
        List<Integer> res=diffWaysToCompute(s);
        System.out.println(res);
    }
}
