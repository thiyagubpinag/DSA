package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class findAndReplacePattern {


    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        String p = normalize(pattern);

        List<String> ans = new ArrayList<String>();
        for (String word : words)
            if (p.equals(normalize(word))) ans.add(word);
        return ans;
    }

    public static String normalize(String str) {

        HashMap<Character, Integer> map = new HashMap<>();

        int len = str.length();

        String ans = "";

        for (int i = 0; i < len; i++) {
            map.putIfAbsent(str.charAt(i), map.size());
            ans += map.get(str.charAt(i));
        }

        return ans;
    }

    public static void main(String[] args) {
        List<String> res = findAndReplacePattern(new String[]{"abcdefghijkba"}, "qwertyuiopwqa");
        System.out.println(res);
        HashMap<Integer,String> map=new HashMap<>();
        map.putIfAbsent(1,"1");
        map.putIfAbsent(1,"2");
        System.out.println(map);
    }
}
