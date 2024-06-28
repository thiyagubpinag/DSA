package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindLongestWord {
    static String findLongestWord(String S, List<String> d) {
        HashMap<Character, Integer> sMap = new HashMap();
        for (int i = 0; i < S.length(); i++) {
            sMap.put(S.charAt(i), sMap.getOrDefault(S.charAt(i), 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        String res = "";
        for (int i = 0; i < d.size(); i++) {
            if (valid(d.get(i), sMap)) {
                if (max < d.get(i).length()) {
                    max = d.get(i).length();
                    res = d.get(i);
                } else if (max == d.get(i).length()) {
                    if (d.get(i).compareTo(res) < 0) {
                        res = d.get(i);
                    }
                }
            }
        }
        return res;
    }

    private static boolean valid(String input, HashMap<Character, Integer> s) {
        HashMap<Character, Integer> sMap = new HashMap();
        for (int i = 0; i < input.length(); i++) {
            sMap.put(input.charAt(i), sMap.getOrDefault(input.charAt(i), 0) + 1);
        }
        for (Character c : sMap.keySet()) {
            if(s.get(c)==null){
                return false;
            }
            if (s.get(c)!=null && sMap.get(c) > s.get(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] d = {"a", "b", "c", "d"};
        String s = "abpcplea";
        List<String> dList = new ArrayList<>();
        for(int i=0;i<d.length;i++)
            dList.add(d[i]);
        String res = findLongestWord(s, dList);
        System.out.println(res);

        String a=String.valueOf(2);
        String[] b=a.split("");
        System.out.println("Done");

    }
}
