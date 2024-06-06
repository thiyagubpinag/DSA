package Recursion;

import java.util.Arrays;
import java.util.Vector;

public class MinimumElements {
    public static int minimumElements(int[] deno, int V) {
        int n = deno.length;
        Vector<Integer> ans = new Vector<>();

        // Traverse through all denomination
        for (int i = n - 1; i >= 0; i--) {
            // Find denominations
            if (deno[i] == 0) {
                continue;
            }
            while (V >= deno[i]) {
                V -= deno[i];
                ans.add(deno[i]);
            }
        }
        return ans.size();
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        int res = minimumElements(coins, amount);
        System.out.println(res);
    }

    static long countWaysToMakeChange(int[] coins, int n, int sum) {
        //Write your cpde here

        long[][] dp = new long[n + 1][sum + 1];
        for (long[] row : dp)
            Arrays.fill(row, -1);
        return count(coins, sum, n, dp);
    }

    static long count(int[] coins, int sum, int n, long[][] dp) {
        // Base Case
        if (sum == 0) return dp[n][sum] = 1;

        // If number of coins is 0 or sum is less than 0 then
        // there is no way to make the sum.
        if (n == 0 || sum < 0) return 0;

        // If the subproblem is previously calculated then
        // simply return the result
        if (dp[n][sum] != -1) return dp[n][sum];

        // Two options for the current coin
        return dp[n][sum] = count(coins, sum - coins[n - 1], n, dp) + count(coins, sum, n - 1, dp);
    }
}
