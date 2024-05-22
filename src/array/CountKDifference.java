package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class CountKDifference {
    public static int countKDifference(int[] nums, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int sum = 0;
        for (Integer value : set) {
            if (set.contains(value + k)) {
                sum += map.get(value) * map.get(value+k);
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {7, 7, 8, 3, 1, 2, 7, 2, 9, 5};
        int k = 6;
        int res = countKDifference(nums, k);
        System.out.println(res);

    }
}
