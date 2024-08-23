package com.cses;

import java.util.Arrays;
import java.util.List;

public class BookShop {
    public static void main(String[] args) {
        // Sample Input
        int N = 4, X = 10;
        int[][] dp = new int[N][X + 1];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
        List<Integer> price = Arrays.asList(4, 8, 2, 3);
        List<Integer> pages = Arrays.asList(5, 40, 19, 20);

        System.out.println(solve(N - 1, X, price, pages, 0, dp));
    }

    private static int solve(int n, int x, List<Integer> price, List<Integer> pages, int profit, int[][] dp) {

        if (x < 0 || n < 0) {
            return profit;
        }
        if(x==0){
            return profit;
        }

        if(dp[n][x]!=-1){
            return dp[n][x];
        }

        int ans;
        if (x < price.get(n)) {
            ans = solve(n - 1, x, price, pages, profit, dp);
        } else {
            ans = Math.max(
                    solve(n - 1, x, price, pages, profit, dp),
                    solve(n - 1, x - price.get(n), price, pages, profit + pages.get(n), dp)
            );
        }
        return dp[n][x] = ans;

    }
}
