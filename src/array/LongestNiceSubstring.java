package array;

import java.util.HashSet;

public class LongestNiceSubstring {
    public static String longestNiceSubstring(String s) {
        if (s.length() < 2) {
            return "";
        }
        HashSet<Character> temp = new HashSet();
        for (int i = 0; i < s.length(); i++) {
            temp.add(s.charAt(i));
        }

        for (int i = 0; i < s.length(); i++) {
            if (temp.contains(Character.toLowerCase(s.charAt(i))) && temp.contains(Character.toUpperCase(s.charAt(i)))) {
                continue;
            }
            String prev = longestNiceSubstring(s.substring(0, i-1));
            String next = longestNiceSubstring(s.substring(i+1));
            return prev.length() > next.length() ? prev : next;
        }

        return s;

    }

    public static void main(String[] args) {
        String res = longestNiceSubstring("YazaAay");
        System.out.println(res);
    }
}
