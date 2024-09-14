package dp;

import java.util.Arrays;
import java.util.Comparator;

public class LongestLengthChain {
    static boolean compare(String a1, String a2) {
        if (a1.length() != a2.length() + 1) return false;
        int left = 0;
        int right = 0;

        while (left < a1.length()) {
            if (right<a2.length() && a1.charAt(left) == a2.charAt(right)) {
                left++;
                right++;
            } else {
                left++;
            }
        }
        if (left == a1.length() && right == a2.length()) {
            return true;
        }
        return false;
    }


    static int getLIS(String[] arr, int index, int prev_index, int[][] dp) {
        if (index == arr.length) {
            return 0;
        }
        if (dp[index][prev_index + 1] != -1) return dp[index][prev_index + 1];

        int len = getLIS(arr, index + 1, prev_index, dp);

        if (prev_index == -1 || compare(arr[index], arr[prev_index])) {
            len = Math.max(len, 1 + getLIS(arr, index + 1, index, dp));
        }
        return dp[index][prev_index + 1] = len;
    }

    public static int longestStrChain(String[] arr) {
        // Write your code here.

        int n = arr.length;
        Arrays.sort(arr, Comparator.comparingInt(String::length));
        int[][] dp = new int[n][n + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return getLIS(arr, 0, -1, dp);
    }

    public static void main(String[] args) {
        String[] input = {"m", "nm", "mmm","mm"};
        int n = input.length;
        int res = longestStrChain(input);
        System.out.println(res);
    }
}
