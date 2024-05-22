package string;

import java.util.*;

public class BucketSortCars {
    static class FrequencySorting {
        Character key;
        Integer value;

        FrequencySorting(Character key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        public Character getKey() {
            return key;
        }
    }

    static String bucketSortCars(String cars) {
        HashMap<Character, Integer> map = new HashMap<>();
        String a="a".substring(2,3);
        for (int i = 0; i < cars.length(); i++) {
            map.put(cars.charAt(i), map.getOrDefault(cars.charAt(i), 0) + 1);
        }
        List<FrequencySorting> frequencySortingList = new ArrayList<>();
        for (Character key : map.keySet()) {
            FrequencySorting frequencySorting = new FrequencySorting(key, map.get(key));
            frequencySortingList.add(frequencySorting);
        }
        frequencySortingList.sort(Comparator.comparingInt(FrequencySorting::getValue).reversed().thenComparing(FrequencySorting::getKey));
        String res = "";
        for (int i = 0; i < frequencySortingList.size(); i++) {
            int value = frequencySortingList.get(i).getValue();
            while (value > 0) {
                res += (frequencySortingList.get(i).key);
                value--;
            }
        }
        return res;

    }


    public static void main(String[] args) {
        String res=bucketSortCars("ssgysyqa");
        System.out.println(res);
    }
}
