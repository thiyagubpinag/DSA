package dp;

import java.util.ArrayList;
import java.util.Arrays;

public class DiceCombinations {
    static int count;
    public static void main(String[] args) {
        int n = 6;
        int target = 4;
        int[][] dp = new int[n + 1][target + 1];
        for (int i = 0; i <= n; i++)
            Arrays.fill(dp[i], -1);
        countWays(target, target, dp, count);
        System.out.println(count);
    }

    private static int countWays(int n, int target, int[][] dp, int count) {
        if (target < 0) {
            return -1;
        }
        if (target == 0) {
            return count;
        }
        for (int i = 1; i <= n; i++) {
            dp[i][target] += countWays(n, target - i, dp, count + 1);
        }
        return dp[n][target];
    }
}
