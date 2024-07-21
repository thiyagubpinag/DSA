package dp;

import java.util.Arrays;
import java.util.zip.InflaterInputStream;

public class MinimizingCoins {
    static int min = Integer.MAX_VALUE;

    static int solve(int sum, int[] arr, int[] dp) {
        if (sum == 0) {
            return 0;
        }
        if (sum < 0) {
            return -1;
        }
        if (dp[sum] != -Integer.MAX_VALUE) return dp[sum];
        for (int i = 0; i < arr.length; i++) {
            int value = solve(sum - arr[i], arr, dp);
            if (value != -1) dp[sum] = Math.min(dp[sum], 1 + value);
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 7};
        int sum = 11;
        int[] dp = new int[sum + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int res = solve(sum, a, dp);
        System.out.println(res);
    }
}
