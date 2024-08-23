package com.cses;

import java.util.Arrays;

public class CoinCombinations {
    public static void main(String[] args) {
        int[] coins = {2, 3, 5};
        int sum = 9;

        int[][] dp=new int [coins.length+1][sum+1];
        for(int i=0;i<=coins.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int res = getWays(coins, sum, coins.length - 1,dp);
        System.out.println(res);
    }

    static int count = 0;

    private static int getWays(int[] coins, int sum, int n, int[][] dp) {
        if (n < 0 || sum < 0) {
            return 0;
        }
        if (sum == 0) {
            return 1;
        }
        if(dp[n][sum]!=-1){
           return dp[n][sum];
        }

        int ans = Integer.MAX_VALUE;
        if (coins[n] > sum) {
            ans = getWays(coins, sum, n - 1, dp);
        } else {
            int exclude = getWays(coins, sum, n - 1, dp);
            int include = getWays(coins, sum - coins[n], n, dp);
            ans=include+exclude;
        }
        return dp[n][sum]= ans;
    }
}
