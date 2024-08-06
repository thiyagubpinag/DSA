package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MinRemoveToMakeValid {
    public static String minRemoveToMakeValid(String s) {
        List<Integer> open = new ArrayList<>();
        List<Integer> close = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open.add(i);
            } else if (s.charAt(i) == ')') {
                close.add(i);
            }
        }
        HashSet<Integer> rem = getIntegers(open, close);

        String result = "";
        for (int k = 0; k < s.length(); k++) {
            if (!rem.contains(k)) {
                result += s.charAt(k);
            }
        }

        return result;

    }

    private static HashSet<Integer> getIntegers(List<Integer> open, List<Integer> close) {
        HashSet<Integer> rem = new HashSet();
        int i = open.size() - 1;
        int j = 0;
        while (i >= 0 || j < close.size()) {
            if (i < 0) {
                rem.add(close.get(j));
                j++;
            } else if (j >= close.size()) {
                rem.add(open.get(i));
                i--;
            } else {
                if (open.get(i) < close.get(j)) {
                    i--;
                } else {
                    rem.add(close.get(j));
                }
                j++;
            }
        }
        return rem;
    }

    public static void main(String[] args) {
        String res = minRemoveToMakeValid("a)b(c)d");
        System.out.println(res);
    }
}
