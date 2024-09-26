package com.dp.revision;

import java.util.Arrays;

public class LCS {
    public static void main(String[] args) {
        String a = "abcde";
        String b = "bde";
        int[][] dp = new int[a.length()+1][b.length()+1];
        getLCS(a, b, a.length(), b.length(), dp);
        int i = a.length(), j = b.length();
        String resStr = "";
        while (i > 0 && j > 0) {
            if (dp[i][j] == dp[i - 1][j - 1] + 1) {
                resStr = (b.charAt(j-1))+resStr;
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        System.out.println(resStr);
    }

    private static int getLCS(String a, String b, int i, int j, int[][] dp) {
        if (i < 1 || j < 1) {
            return 0;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        if (a.charAt(i-1) == b.charAt(j-1)) {
            return dp[i][j] = getLCS(a, b, i - 1, j - 1, dp) + 1;
        }
        return dp[i][j] = Math.max(getLCS(a, b, i, j - 1, dp), getLCS(a, b, i - 1, j, dp));
    }
}
