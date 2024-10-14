package array;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String a = "ADOBECODEBANC";
        String t = "ABC";

        minWindow(a, t);


    }

    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> temp = new HashMap();
        HashMap<Character, Integer> map = new HashMap();
        for (int i = 0; i < t.length(); i++) {
            temp.put(t.charAt(i), temp.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0;
        int right = 0;
        int n = s.length();
        String result = "";
        int minValue = Integer.MAX_VALUE;
        while (right < n) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            if (compareBothMap(temp, map)) {
                while (true) {
                    char tempChar = s.charAt(left);
                    if (Objects.equals(map.get(tempChar), temp.get(tempChar))) {
                        if (map.get(tempChar) == 1) {
                            map.remove(tempChar);
                        } else {
                            map.put(tempChar, map.get(tempChar) - 1);
                        }
                        if ((right - left) < minValue) {
                            minValue = right - left + 1;
                            result = s.substring(left, right+1);
                        }
                        left++;
                        break;
                    } else {
                        map.put(tempChar, map.get(tempChar) - 1);
                    }
                    left++;
                }

            }
            right++;
        }
        return result;

    }

    private static boolean compareBothMap(HashMap<Character, Integer> temp, HashMap<Character, Integer> map) {

        for (Map.Entry<Character, Integer> entry : temp.entrySet()) {
            if (map.get(entry.getKey()) == null) {
                return false;
            }
            if (temp.get(entry.getKey()) > map.get(entry.getKey())) {
                return false;
            }
        }

        return true;
    }
}
