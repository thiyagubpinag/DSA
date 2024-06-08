package Recursion;

import java.util.Arrays;

public class Knapsack {
    public static int knapsack(int[] wt, int[] val, int n, int w) {
        //Write your code here
        int[][] memo = new int[n + 1][w + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return knapsack(wt, val, n - 1, w, memo);

    }

    public static int knapsack(int[] wt, int[] val, int n, int w, int[][] memo) {
        if (n < 0 | w < 0) {
            return 0;
        }

        if (memo[n][w] != -1) {
            return memo[n][w];
        }

        if (wt[n] > w) {
            memo[n][w] = knapsack(wt, val, n - 1, w, memo);
        } else {
            memo[n][w] = Math.max(knapsack(wt, val, n - 1, w, memo), val[n] + knapsack(wt, val, n - 1, w - wt[n], memo));
        }

        return memo[n][w];
    }
}
