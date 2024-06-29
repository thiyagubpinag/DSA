package array;

import java.util.HashMap;
import java.util.TreeSet;

public class SmallerNumbersThanCurrent {
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];
        TreeSet<Integer> sortedSet = new TreeSet<>();
        HashMap<Integer, Integer> tempMap = new HashMap<>();
        int sum;
        for (int i = 0; i < nums.length; i++) {
            sortedSet.add(nums[i]);
            tempMap.put(nums[i], tempMap.getOrDefault(nums[i], 0)+1);
        }

        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (Integer value : sortedSet) {
                if (value < nums[i]) {
                    sum = sum+tempMap.get(value);
                } else {
                    break;
                }
            }
            result[i] =sum;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {8, 1, 2, 2, 3};
        int[] result = smallerNumbersThanCurrent(nums);

        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }

        TreeSet<Integer> set=new TreeSet<>();

    }
}
