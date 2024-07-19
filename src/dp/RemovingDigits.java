package dp;

import java.util.Arrays;

public class RemovingDigits {
    static int solve(int n, int[] dp) {
        if (n <= 9) {
            return 1;
        }

        if (dp[n] != Integer.MAX_VALUE) {
            return dp[n];
        }
        int ans = Integer.MAX_VALUE;
        String nStr = String.valueOf(n);
        for (int i = 0; i < nStr.length(); i++) {
            int digit = Integer.parseInt(String.valueOf(nStr.charAt(i)));
            if (digit != 0) {
                int value = solve(n - digit, dp);
                if (value != Integer.MAX_VALUE) {
                    ans = Math.min(ans, value + 1);
                }
            }
        }
        return dp[n] = ans;
    }

    public static void main(String[] args) {
        int n = 44;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int res = solve(n, dp);
        System.out.println(res);
    }
}
