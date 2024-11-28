package com.cses;

import java.util.Arrays;

public class DiceCombination {
    public static void main(String[] args) {
        int n=5;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        int result=getCombination(n,dp);
        System.out.println(result);
    }

    private static int getCombination(int n,int[] dp) {
        if(n==0)return 1;
        if(n<0) return 0;
        if(dp[n]!=-1) return dp[n];
        int ans=0;
        for(int i=1;i<=6;i++){
            ans+=getCombination(n-i,dp);
        }
        return dp[n]=ans;
    }
}
