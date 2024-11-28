package com.practise;

import java.util.ArrayList;
import java.util.List;

public class SubsetSum {
    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 6, 1, 4};
        int target = 7;
        boolean[][] dp = new boolean[arr.length][target + 1];
        boolean sum = subset(arr, target, arr.length - 1, dp);
        System.out.println(sum);
    }

    private static boolean subset(int[] arr, int target, int n, boolean[][] dp) {

        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 0; i <= target; i++) {
            dp[0][arr[0]] = true;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - arr[i] >= 0) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i]];
                }
            }
        }
        List<Integer> arrayList = new ArrayList<>();
        printSubset(dp, arr.length - 1, target, arrayList, arr);
        return dp[arr.length - 1][target];
    }

    private static void printSubset(boolean[][] dp, int n, int sum, List<Integer> arrayList, int[] arr) {
        if (n < 0) {
            return;
        }
        if (sum == 0) {
            System.out.println(new ArrayList<>(arrayList));
            return;
        }
        if (n == 0 && dp[0][sum]) {
            arrayList.add(arr[n]);
            System.out.println(new ArrayList<>(arrayList));
            return;
        }
        if (n>=1 && dp[n - 1][sum]) {
            List<Integer> temp = new ArrayList<>();
            temp.addAll(arrayList);
            printSubset(dp, n - 1, sum, temp, arr);
        }

        if (sum >= arr[n]) {
            arrayList.add(arr[n]);
            printSubset(dp, n - 1, sum - arr[n], arrayList, arr);
        }
    }


}
