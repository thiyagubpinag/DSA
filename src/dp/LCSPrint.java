package dp;

import java.util.Arrays;

public class LCSPrint {
    public static void main(String[] args) {
        String a = "abac";
        String b = "cab";
        int m = a.length();
        int n = b.length();
        int[][] memo = new int[m + 1][n + 1];
        int res = findLcs(a, b, m, n, memo);
        int i = m;
        int j = n;

        StringBuilder resStr = new StringBuilder("");
        while (i > 0 && j > 0) {
            if (a.charAt(i-1) == b.charAt(j-1) && memo[i - 1][j - 1] == memo[i][j] - 1) {
                resStr.insert(0, a.charAt(i-1));
                j--;
                i--;
            } else if (memo[i - 1][j] > memo[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        System.out.println(i + "," + j);
        System.out.println(resStr.toString());

       // knapSackProblem("abc", 2, "");

    }

    private static int findLcs(String a, String b, int m, int n, int[][] memo) {
        if (m < 1 || n < 1) {
            return 0;
        }
        if (memo[m][n] != 0) {
            return memo[m][n];
        }
        if (a.charAt(m - 1) == b.charAt(n - 1)) {
            return memo[m][n] = 1 + findLcs(a, b, m - 1, n - 1, memo);
        }

        return memo[m][n] = Math.max(findLcs(a, b, m - 1, n, memo), findLcs(a, b, m, n - 1, memo));

    }

    boolean Palindrome(String s, int left, int right) {
        if (left > right) {
            return false;
        }
        if (s.charAt(left) == s.charAt(right)) {
            return Palindrome(s, left + 1, right - 1);
        }
        return false;
    }

    static void knapSackProblem(String s, int n, String ans) {
        if (n < 0) {
            System.out.println(ans);
            return;
        }

        knapSackProblem(s, n - 1, s.charAt(n) + ans);
        knapSackProblem(s, n - 1, ans);

    }

}
