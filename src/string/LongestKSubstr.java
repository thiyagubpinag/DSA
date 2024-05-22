package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestKSubstr {
    public static void main(String[] args) {
        String s = "aabacbebaaaafsaaebe";
        int k = 3;
        Map<Character, Integer> map = new HashMap<>();

        char[] arr = s.toCharArray();
        int left = 0, right = 0, n = arr.length;
        int longestLen = 0;

        while(right < n){
            //Expand the window
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

            //Shrink the window if window size exceeds the k distinct characters
            while(k < map.size()){
                if(map.get(arr[left]) == 1){
                    map.remove(arr[left]);
                }else{
                    map.put(arr[left], map.get(arr[left]) - 1);
                }
                left++;
            }

            //Update the longest length
            longestLen = Math.max(longestLen, right - left + 1);

            right++;
        }
        System.out.println(longestLen);
    }
}
