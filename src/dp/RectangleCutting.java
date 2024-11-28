package dp;

import java.util.Arrays;

public class RectangleCutting {
    public static void main(String[] args) {
        int m = 3;
        int n = 5;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    dp[i][j] = 0;
                    continue;
                }

                for (int v = 1; v <= i - 1; v++) {
                    dp[i][j] = Math.min(dp[i][j], dp[v][j]+dp[i-v][j]+1);
                }

                for (int l = 1; l <= j - 1; l++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][l]+dp[i][j-l]+1);
                }

            }
        }

        System.out.println("Done");

    }
}
