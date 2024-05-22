package string;

import java.util.HashMap;
import java.util.HashSet;

public class NumberOfSubstrings {
    public static int numberOfSubstrings(String s) {
        int count = 0;
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] temp = s.toCharArray();
        int n = temp.length;
        while (right < n) {
            map.put(temp[right], map.getOrDefault(temp[right], 0) + 1);
            while (map.containsKey('a') && map.containsKey('b') && map.containsKey('c')) {
                count += (n - right);
                int counter=map.get(temp[left]);
                if(counter==1){
                    map.remove(temp[left]);
                }else{
                    map.put(temp[left],counter-1);
                }
                left++;
            }
            right++;
        }
        return count;
    }


    public static void main(String[] args) {
        int res = numberOfSubstrings("aaacb");
        System.out.println(res);
    }
}
