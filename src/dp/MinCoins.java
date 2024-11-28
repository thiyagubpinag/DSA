package dp;

import java.util.Arrays;

public class MinCoins {


    public static void main(String[] args) {
        int[] a = {1, 5, 7, 4,11,10};
        int target = 17;
        int[] dp = new int[target+1];
        Arrays.fill(dp, -1);
        int min = minimizeCoins(a, target, dp);
        System.out.println(min);
    }

    private static int minimizeCoins(int[] a, int target, int[] dp) {
        if (target < 0) {
            return -1;
        }
        if (target == 0) {
            return 0;
        }
        if (dp[target] != -1) {
            return dp[target];
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            int val = minimizeCoins(a, target - a[i], dp);
            if (val != -1) {
                ans = Math.min(ans, 1 + val);
            }
        }
        return dp[target] = ans;
    }
}
