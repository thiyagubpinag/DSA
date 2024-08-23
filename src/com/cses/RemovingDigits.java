package com.cses;

import java.util.Arrays;

public class RemovingDigits {
    public static void main(String[] args) {
        int n = 27;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int res = getMinimumSteps(n, dp);

        System.out.println(res);
    }

    private static int getMinimumSteps(int n, int[] dp) {
        if (dp[n] != -1) {
            return dp[n];
        }
        if (n == 0) {
            return 0;
        }

        String a = n + "";

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < a.length(); i++) {
            int digit = Integer.parseInt(String.valueOf(a.charAt(i)));
            if (digit != 0) {
                ans = Math.min(ans, 1 + getMinimumSteps(n - digit, dp));
            }
        }
        return dp[n] = ans;
    }
}
