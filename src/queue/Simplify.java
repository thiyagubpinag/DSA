package queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Simplify {
    public static String simplify(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] dirs = path.split("/");
        for (String dir : dirs) {
            if (!dir.isEmpty() && !dir.equals(".")) {
                //popping if .. is found
                if (!dir.equals("..")) stack.addLast(dir);
                    //pushing if stack is not empty
                else if (!stack.isEmpty()) stack.pollLast();
            }
        }
        String finalPath = "";
        if (stack.isEmpty()) {
            //adding / to the final string
            finalPath += "/";
        } else {
            //traversing through whole queue and adding to the final answer
            for (String str : stack) {
                finalPath += "/";
                finalPath += str;
            }
        }
        return finalPath;
    }

    public static void main(String[] args) {
        // absolute path which we have to simplify.
        String str = "/a/./b/../../c/";
        String res = simplify(str);
        System.out.print(res);
    }
}
