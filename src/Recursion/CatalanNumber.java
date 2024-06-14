package Recursion;

import java.util.ArrayList;
import java.util.List;

public class CatalanNumber {
    public static void main(String[] args) {
        int n = 15;
        dp = new int[n];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 0; i < n - 2; i++) {
            getCalatalanNumber(i + 2);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(dp[i] + " ");
        }
    }

    static int[] dp;

    static int getCalatalanNumber(int n) {
        if (dp[n] != 0) {
            return dp[n];
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += (getCalatalanNumber(i) * getCalatalanNumber(n - i - 1));
        }

        return dp[n] = result;
    }
}
