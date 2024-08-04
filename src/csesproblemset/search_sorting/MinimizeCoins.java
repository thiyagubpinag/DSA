package csesproblemset.search_sorting;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MinimizeCoins {
    public static void main(String[] args) {
        // Sample Input
        int N = 3, X = 10;
        List<Integer> coins = Arrays.asList(1, 2, 3,4, 6);
        int[] dp = new int[X + 1];
        Arrays.fill(dp, -1);
        int res = solve(N, X, coins, dp);
        System.out.println(res);
    }

    private static int solve(int n, int x, List<Integer> coins, int[] dp) {
        return minimizeCoins(n - 1, x, coins, 0, dp);
    }

    private static int minimizeCoins(int i, int x, List<Integer> coins, int count, int[] dp) {
        if (x < 0) {
            return Integer.MAX_VALUE;
        }
        if (x == 0) {
            return count;
        }
        if (dp[x] != -1) {
            return dp[x];
        }
        int min = Integer.MAX_VALUE;
        for (int k = coins.size() - 1; k >= 0; k--) {
            min = Math.min(minimizeCoins(k, x - coins.get(k), coins, count + 1, dp), min);
        }
        dp[x] = min == Integer.MAX_VALUE ? -1 : min;
        return dp[x];
    }
}
