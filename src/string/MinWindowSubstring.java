package string;
import java.util.*;
public class MinWindowSubstring {
        public static String minWindow(String s, String t) {

            Map<Character, Integer> targetMap = new HashMap<>();
            for (char c : t.toCharArray()) {
                targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
            }

            int left = 0, right = 0;
            int minLen = Integer.MAX_VALUE;
            int minStart = 0;
            int requiredChars = t.length();

            while (right < s.length()) {
                char currentChar = s.charAt(right);
                if (targetMap.containsKey(currentChar)) {
                    if (targetMap.get(currentChar) > 0) {
                        requiredChars--;
                    }
                    targetMap.put(currentChar, targetMap.get(currentChar) - 1);
                }

                while (requiredChars == 0) {
                    if (right - left + 1 < minLen) {
                        minLen = right - left + 1;
                        minStart = left;
                    }

                    char leftChar = s.charAt(left);
                    if (targetMap.containsKey(leftChar)) {
                        targetMap.put(leftChar, targetMap.get(leftChar) + 1);
                        if (targetMap.get(leftChar) > 0) {
                            requiredChars++;
                        }
                    }

                    left++;
                }

                right++;
            }

            return (minLen == Integer.MAX_VALUE) ? "" : s.substring(minStart, minStart + minLen);
        }

    public static void main (String[] args){
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }
}
