package array;

import java.util.HashMap;
import java.util.HashSet;

public class FindDuplicate {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 2, 1};
        int k = 7;
        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int i = 0;
        int right = left + k;
        int n = nums.length;

        while (i < right) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            i++;
        }
        while (right < n) {
            if (map.containsKey(nums[right])) {
                System.out.println("Duplicate Found");
            }
            int count = map.get(nums[left]);
            if (count == 1) {
                map.remove(nums[left]);
            } else {
                map.put(nums[left], count - 1);
            }
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            left++;
            right++;
        }

        System.out.println("Done");

    }
}
