package array;

import java.util.Arrays;

public class Rob {
    public int robRec(int[] nums, int n, int[] dp) {
        if (n < 0) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int include = nums[n] + robRec(nums, n - 2, dp);
        int exclude = robRec(nums, n - 1, dp);
        return dp[n] = Math.max(include, exclude);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return robRec(nums, n - 1, dp);
    }

    public static void main(String[] args) {
        Rob rob = new Rob();
        int[] nums = {1, 2, 3, 1};
        int output = rob.rob(nums);
        System.out.println(output);
    }
}
