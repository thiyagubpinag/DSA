package string;

import java.util.Stack;

public class Interpret {
    public static String interpret(String command) {
        Stack<Character> temp = new Stack<>();
        for (int i = 0; i < command.length(); i++) {
            temp.add(command.charAt(i));
        }
        StringBuilder res = new StringBuilder();
        StringBuilder tmpStr = new StringBuilder();
        while (!temp.isEmpty()) {
            if (temp.peek() == ')') {
                while (!temp.isEmpty()) {
                    if (temp.peek() == '(') {
                        if (tmpStr.isEmpty()) {
                            res.insert(0, 'o');
                        }
                        break;
                    }
                    if (temp.peek() != ')') tmpStr.insert(0, temp.peek());
                    temp.pop();
                }
                res.insert(0, tmpStr);
                tmpStr.setLength(0);
            } else {
                res.insert(0, temp.peek());
            }
            temp.pop();
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String command = "G()()()()(al)";
        String res = interpret(command);
        System.out.println(res);

        String s="codeleet";
        int[] indices={4,5,6,7,0,2,1,3};

        StringBuilder builder=new StringBuilder(s);
        for(int i=0;i<indices.length;i++){
            builder.setCharAt(indices[i],s.charAt(i));
        }
        System.out.println(builder.toString());
    }
}
