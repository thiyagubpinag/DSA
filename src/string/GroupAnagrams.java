package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> resultList = new ArrayList<>();
        HashMap<Map<Character, Integer>, List<String>> map = new HashMap<>();
        int n = strs.length;

        for (int i = 0; i < n; i++) {
            Map<Character, Integer> tempMap = new HashMap();
            for (int j = 0; j < strs[i].length(); j++) {
                tempMap.put(strs[i].charAt(j), tempMap.getOrDefault(strs[i].charAt(j), 0) + 1);
            }
            List<String> temp = map.getOrDefault(tempMap, new ArrayList<>());
            temp.add(strs[i]);
            map.put(tempMap, temp);
        }

        map.values().forEach(i -> resultList.add(i));


        return resultList;
    }

    public static void main(String[] args) {
        String[] a = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> resultList = groupAnagrams(a);
        System.out.println(resultList);
    }
}
