package array;

import java.util.*;

public class LIS {
    public static int lengthOfLIS(int[] nums) {
        int[] nums1 = Arrays.stream(nums).distinct().toArray();
        int n = nums1.length;
        int arr[] = Arrays.copyOf(nums1, n);
        Arrays.sort(arr);
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);
        int res = getLCS(nums1, arr, n - 1, n - 1, dp);
        return res;
    }

    public static int getLCS(int[] nums, int[] sortedNums, int i, int j, int[][] dp) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (nums[i] == sortedNums[j]) {
            return dp[i][j] = 1 + getLCS(nums, sortedNums, i - 1, j - 1, dp);
        }

        return dp[i][j] = Math.max(getLCS(nums, sortedNums, i - 1, j, dp), getLCS(nums, sortedNums, i, j - 1, dp));

    }

    public static void main(String[] args) {
        int[] arr = {0,1,0,3,2,3};
        int res=lengthOfLIS(arr);
        System.out.println(res);

    }
}
