package string;

import java.util.HashMap;

public class LongestRepeatingCharacter {
    public static int getMaximumFrequenct(HashMap<Character, Integer> map) {
        int max = Integer.MIN_VALUE;
        for (Character key : map.keySet()) {
            max = Math.max(map.get(key), max);
        }
        return max;
    }

    public static int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap();
        int left = 0;
        int right = 0;
        int n = s.length();
        int result = Integer.MIN_VALUE;
        while (right < n) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            int max = getMaximumFrequenct(map);
            int len = right - left + 1;
            if (len - max <= k) {
                result = Math.max(result, len);
            } else {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        int res = characterReplacement(s, k);
        System.out.println(res);
    }
}
