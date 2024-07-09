package dp;

public class MinimizeCons {
    public static void main(String[] args) {
        int N = 3;
        int X = 6;
        int[] coins = {1, 2, 3};
        int[][] dp = new int[X + 1][X];
        int res = minimizeCoins(0, X, 0, coins, dp);
        System.out.println(res);

    }

    private static int minimizeCoins(int index, int x, int count, int[] coins, int[][] dp) {
        if (x < 0) {
            return Integer.MAX_VALUE;
        }
        if (x == 0) {
            return count;
        }
        if (dp[index][x] != -1) {
            return dp[index][x];
        }
        for (int i = 0; i < coins.length; i++) {
            dp[i][x] = Math.min(dp[i][x], minimizeCoins(i, x - coins[i], count + 1, coins, dp));
        }
        return -1;
    }
}
