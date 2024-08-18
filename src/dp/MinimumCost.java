package dp;

import java.util.Arrays;

public class MinimumCost {
    public static int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 || j == 1) {
                    dp[i][j] = 0;
                    if (i == 1) {
                        for (int k = 1; k < j; k++) {
                            dp[i][j] += verticalCut[k - 1];
                        }
                    }
                    if (j == 1) {
                        for (int k = 1; k < i; k++) {
                            dp[i][j] += horizontalCut[k - 1];
                        }
                    }
                } else {
                    if (i == j) {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + dp[i - 1][j] + dp[i][j - 1];
                        continue;
                    }
                    for (int k = 1; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[i][j - k] + verticalCut[k-1]);
                    }

                    for (int k = 1; k < i; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[k][j] + dp[i - k][j] + horizontalCut[k-1]);
                    }


                }

            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        int[] hCut = {1, 3};
        int[] vCut = {5};
        int m = 3;
        int n = 2;
        int res = minimumCost(m, n, hCut, vCut);
        System.out.println(res);

    }
}
