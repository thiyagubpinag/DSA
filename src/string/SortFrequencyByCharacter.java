package string;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class SortFrequencyByCharacter {
    static class Fsort {
        char key;
        int value;

        public Fsort(char key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        List<Fsort> fsortList = new ArrayList<>();
        for (Character ch : map.keySet()) {
            fsortList.add(new Fsort(ch, map.get(ch)));
        }

        fsortList.sort((i, j) -> {
            return j.value - i.value;
        });

        String res = "";
        for (Fsort fsort : fsortList) {
            for (int i = 0; i < fsort.value; i++) {
                res += fsort.key;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        frequencySort("tree");
    }
}
