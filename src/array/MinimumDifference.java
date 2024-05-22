package array;

import java.util.Arrays;

public class MinimumDifference {
    public static int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int j = 0;
        while (j + k - 1 < nums.length) {
            min = Math.min(min, nums[j + k - 1] - nums[j]);
            j++;
        }

        return min;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{9, 4, 1, 7};
        int k = 2;
        int res = minimumDifference(nums, k);
        System.out.println(res);
    }
}
