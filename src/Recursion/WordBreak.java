package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        String a = "a";
        String[] b = {"b"};
        boolean ans = wordBreak(a, new ArrayList<>(Arrays.asList(b)));
        System.out.println(ans);
    }

    static HashSet<String> set = new HashSet();

    public static boolean wordBreak(String s, List<String> wordDict) {
        wordDict.forEach(i -> {
            set.add(i);
        });

        return wordBreakUtil(s);
    }

    public static boolean wordBreakUtil(String s) {
        int n = s.length();
        if (n == 0) {
            return true;
        }

        for (int k = 0; k < n; k++) {
            String firstStr = s.substring(0, k + 1);
            String remaingStr = s.substring(k + 1, n);
            if (set.contains(firstStr) && wordBreakUtil(remaingStr)) {
                return true;
            }
        }

        return false;
    }
}
