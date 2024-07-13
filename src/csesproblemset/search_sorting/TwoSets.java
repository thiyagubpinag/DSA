package csesproblemset.search_sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class TwoSets {
    public static void main(String[] args) {
        int n = 3;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (i + 1);
        }
        if (sum % 2 != 0) {
            System.out.println(0);
        } else {
            sum = sum / 2;
            int[][] dp = new int[n + 1][sum + 1];
            for (int i = 0; i <= n; i++)
                Arrays.fill(dp[i], -1);
            int res = subset(n, sum, dp);
            System.out.println(res);
        }
        tabulationSubset(n, n);
    }

    private static void tabulationSubset(int n, int sum) {
        boolean[][] dp = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - i >= 0) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - i];
                }
            }
        }

        System.out.println(dp[n][sum]);

        printSubsetSum(n, dp, 3, new ArrayList<>());

    }

    private static void printSubsetSum(int n, boolean[][] dp, int sum, ArrayList<Integer> list) {
        if (n <= 0) {
            return;
        }
        if(n==1 && sum==n){
            list.add(n);
            System.out.println(list);
            return;
        }
        if (sum == 0) {
            System.out.println(list);
            return;
        }
        if (dp[n - 1][sum]) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.addAll(list);
            printSubsetSum(n - 1, dp, sum, temp);
        }
        if (sum - n >= 0) {
            list.add(n);
            printSubsetSum(n - 1, dp, sum - n, new ArrayList<>(list));
        }
    }

    public static int subset(int n, int sum, int[][] dp) {
        if (n <= 0) {
            return -1;
        }
        if (sum == 0) {
            return 0;
        }
        if (dp[n][sum] != -1) {
            return dp[n][sum];
        }
        if (n > sum) {
            return dp[n][sum] = subset(n - 1, sum, dp);
        } else {
            return dp[n][sum] = Math.max(1 + subset(n - 1, sum - n, dp), subset(n - 1, sum, dp));
        }

    }
}
