package Recursion;

import java.util.Arrays;

public class LCS {


    public static void main(String[] args) {
        String a = "dassbaadbc";
        String b = "dcbaadcbc";
        int[][] memo = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i <= a.length(); i++) {
            Arrays.fill(memo[i], -1);
        }
        int res = getLCS(a, b, a.length() - 1, b.length() - 1, memo, 0);
        String resStr = start == 0 ? "" : a.substring(start, start + res);
        System.out.println(resStr);
    }

    public static int maxValue = Integer.MIN_VALUE;
    public static int start = 0;

    private static int getLCS(String a, String b, int m, int n, int[][] memo, int count) {
        if (m == -1 || n == -1) {
            return count;
        }
        if (memo[m][n] != -1) {
            return memo[m][n];
        }
        if (a.charAt(m) == b.charAt(n)) {
            memo[m][n] = getLCS(a, b, m - 1, n - 1, memo, count + 1);
            if (maxValue < memo[m][n]) {
                start = m;
                maxValue = memo[m][n];
            }
            return memo[m][n];
        }
        memo[m][n] = Math.max(count, Math.max(getLCS(a, b, m, n - 1, memo, 0), getLCS(a, b, m - 1, n, memo, 0)));
        return memo[m][n];
    }
}
