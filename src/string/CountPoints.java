package string;

import java.util.HashMap;
import java.util.HashSet;

public class CountPoints {
    public static int countPoints(String rings) {
        int sum = 0;
        if (rings.length() < 2) {
            return sum;
        }
        int n = rings.length();
        HashMap<Integer, HashSet<Character>> tempMap = new HashMap<>();
        for (int i = 1; i < n; i += 2) {
            HashSet<Character> tempSet = tempMap.getOrDefault((int) rings.charAt(i), new HashSet<>());
            tempSet.add(rings.charAt(i - 1));
            tempMap.put((int) rings.charAt(i), tempSet);
        }
        for (Integer key : tempMap.keySet()) {
            if (tempMap.get(key).size() == 3) {
                sum += 1;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int res = countPoints("B0B6G0R6R0R6G9");
        System.out.println(res);
    }
}
