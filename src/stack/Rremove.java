package stack;

import java.util.Arrays;
import java.util.Stack;

public class Rremove {
    public static String rremove(String S) {
        char[] newString = S.toCharArray(); // Convert the string to a char array
        Stack<Character> stack = new Stack<>(); // Initialize an empty stack
        int i = 0; // Initialize the index variable

        while (i < S.length()) {
            // Check if stack is not empty and top of stack is the same as S[i]
            if (!stack.isEmpty() && stack.peek() == S.charAt(i)) {
                // Remove consecutive characters equal to the top of the stack
                while (i < S.length() && S.charAt(i) == stack.peek()) {
                    i++;
                }
                stack.pop();
            }

            // If S[i] is different from top of the stack, push it onto the stack
            if (i < S.length()) {
                stack.push(S.charAt(i));
                i++;
            }
        }

        // Check if resulting string is the same as the original string
        char[] stackArray = new char[stack.size()];
        for (int j = 0; j < stackArray.length; j++) {
            stackArray[j] = stack.get(j);
        }

        if (Arrays.equals(newString, stackArray)) {
            StringBuilder result = new StringBuilder();
            for (char c : newString) {
                result.append(c);
            }
            return result.toString(); // Return the resulting string
        } else {
            StringBuilder result = new StringBuilder();
            for (char c : stackArray) {
                result.append(c);
            }
            return rremove(result.toString()); // Recursively call rremove with the resulting string as input
        }
    }

    public static void main(String[] args) {
        String inputString = "azxxzy";

        // Function call
        String outputString = rremove(inputString);
        System.out.println("Output: " + outputString);
    }
}
