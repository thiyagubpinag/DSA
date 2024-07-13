package dp;

import java.util.Arrays;

public class LCSPractise {
    public static void main(String[] args) {
        String s1 = "bbabacaa";
        String s2 = "cccababab";

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        getLcs(s1, s2, s1.length(), s2.length(), dp);

        System.out.println(dp[s1.length()][s2.length()]);
        int i = s1.length();
        int j = s2.length();
        StringBuilder res = new StringBuilder();
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1) && dp[i][j] == 1 + dp[i - 1][j - 1]) {
                res.insert(0, s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        i = 0;
        j = 0;
        String lcsStr = res.toString();
        int index = 0;
        String resStr = "";
        while (i < s1.length() && j < s2.length() && index < lcsStr.length()) {
            if (s1.charAt(i) == s2.charAt(j) && s1.charAt(i) == lcsStr.charAt(index)) {
                resStr += s1.charAt(i);
                i++;
                j++;
                index++;
            } else if (s1.charAt(i) != s2.charAt(j) && s1.charAt(i) == lcsStr.charAt(index)) {
                resStr += s2.charAt(j);
                j++;
            } else {
                resStr += s1.charAt(i);
                i++;
            }
        }

        while (i < s1.length()) {
            resStr += s1.charAt(i);
            i++;
        }

        while (j < s2.length()) {
            resStr += s2.charAt(j);
            j++;
        }

        System.out.println(resStr);

    }

    private static int getLcs(String s1, String s2, int m, int n, int[][] dp) {
        if (m == 0 || n == 0) return 0;
        if (dp[m][n] != 0) {
            return dp[m][n];
        }
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            dp[m][n] = 1 + getLcs(s1, s2, m - 1, n - 1, dp);
        } else {
            dp[m][n] = Math.max(getLcs(s1, s2, m - 1, n, dp), getLcs(s1, s2, m, n - 1, dp));
        }
        return dp[m][n];
    }
}
