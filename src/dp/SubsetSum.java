package dp;

import java.util.Arrays;

public class SubsetSum {
    public static void main(String[] args) {
        int[] arr = {1, 5, 7, 4, 6};
        int sum = 11;
        int[][] memo = new int[arr.length][sum + 1];
        for(int i=0;i<arr.length;i++){
            Arrays.fill(memo[i],-1);
        }
        int res = subsetSum(arr, arr.length - 1, sum, memo);
        System.out.println(res);
    }

    private static int subsetSum(int[] arr, int n, int sum, int[][] memo) {
        if (n < 0 || sum < 0) {
            return 0;
        }
        if (memo[n][sum] != -1) return memo[n][sum];
        if (sum == 0) {
            return 1;
        }
        int ans;
        int include = subsetSum(arr, n - 1, sum - arr[n], memo);
        int exclude = subsetSum(arr, n - 1, sum, memo);
        ans = include + exclude;
        memo[n][sum] = ans;
        return memo[n][sum];
    }
}
