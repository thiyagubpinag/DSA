package queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class FirstNonRep {
    public static String firstNonRep(String str) {
        //Write your code here
        char[] charArr = str.toCharArray();
        String outputStr = "";
        HashMap<Character, Integer> map = new HashMap();
        Deque<Character> deque = new ArrayDeque<>();

        for (char ch : charArr) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if (map.get(ch) == 1) {
                deque.add(ch);
            }



            outputStr+=(deque.isEmpty()?'X':deque.peek());
        }

        return outputStr;

    }

    public static void main(String[] args) {
        String res = firstNonRep("bbe");
        System.out.println(res);
    }
}
