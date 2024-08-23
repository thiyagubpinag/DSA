package dp;

import java.util.Arrays;

public class LongestCommonSubstring {

    public static void main(String[] args) {
        longestPalindrome("babad");

    }
    public static String longestPalindrome(String s) {
        String a=s;
        String b=new StringBuilder(s).reverse().toString();
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i <= a.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        getLCSCount(a,b,s.length()-1,s.length()-1,dp);
        System.out.println(max);
        return "";
    }

    static int max = Integer.MIN_VALUE;

    private static int getLCSCount(String a, String b, int m, int n, int[][] dp) {
        if (m < 0 || n < 0) {
            return 0;
        }
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        if (a.charAt(m) == b.charAt(n)) {
            int maxLength = 1 + getLCSCount(a, b, m - 1, n - 1, dp);
            max = Math.max(max, maxLength);
            return dp[m][n] = maxLength;
        } else {
            getLCSCount(a, b, m - 1, n, dp);
            getLCSCount(a, b, m, n - 1, dp);
        }
        return dp[m][n] = 0;
    }
}
