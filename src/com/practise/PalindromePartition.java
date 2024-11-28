package com.practise;

import java.util.Arrays;

public class PalindromePartition {
    public static void main(String[] args) {
        String a = "sagar";
        int[][] dp=new int[a.length()][a.length()];
        for(int i=0;i<a.length();i++)
            Arrays.fill(dp[i],-1);
        int ans = palindromeParttiton(a, 0, a.length() - 1,dp);
        System.out.println(ans);
    }

    private static int palindromeParttiton(String a, int i, int j, int[][] dp) {
        if (i >= j) {
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if (isPalindrome(a, i, j)) {
            return 0;
        }
        int min=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int var=palindromeParttiton(a,i,k, dp)+palindromeParttiton(a,k+1,j, dp)+1;
            min=Math.min(var,min);
        }
        return dp[i][j]=min;
    }

    private static boolean isPalindrome(String a, int i, int j) {
        while (i <= j) {
            if (a.charAt(i) != a.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
