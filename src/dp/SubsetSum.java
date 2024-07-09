package dp;

import java.util.*;

public class SubsetSum {
    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 1};
        int k = 11;
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][k + 1];
        int tab[][] = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                tab[i][j] = -1;
            }
        }
        int res = subsetSum(arr, n, k, tab);
        //boolean res=isSubsetSum(arr,n,k);
        System.out.println(res);
    }

    private static boolean subsetSum(int[] arr, int n, int sum, boolean[][] dp) {
        if (sum == 0) {
            return true;
        }
        if (n < 0) {
            return false;
        }
        if (dp[n][sum]) {
            return true;
        }
        if (arr[n] > sum) {
            dp[n][sum] = subsetSum(arr, n - 1, sum, dp);
            return dp[n][sum];
        }

        boolean include = subsetSum(arr, n - 1, sum - arr[n], dp);
        boolean exclude = subsetSum(arr, n - 1, sum, dp);
        dp[n][sum] = include || exclude;
        return dp[n][sum];

    }

    static boolean isSubsetSum(int set[], int n, int sum) {
        // The value of subset[i][j] will be
        // true if there is a subset of
        // set[0..j-1] with sum equal to i
        boolean subset[][] = new boolean[sum + 1][n + 1];

        // If sum is 0, then answer is true
        for (int i = 0; i <= n; i++)
            subset[0][i] = true;

        // If sum is not 0 and set is empty,
        // then answer is false
        for (int i = 1; i <= sum; i++)
            subset[i][0] = false;

        // Fill the subset table in bottom
        // up manner
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                subset[i][j] = subset[i][j - 1];
                if (i >= set[j - 1]) subset[i][j] = subset[i][j] || subset[i - set[j - 1]][j - 1];
            }
        }

        return subset[sum][n];
    }

    static int subsetSum(int a[], int n, int sum, int tab[][]) {


        // If the sum is zero it means
        // we got our expected sum
        if (sum == 0) return 1;

        if (n <= 0) return 0;

        // If the value is not -1 it means it
        // already call the function
        // with the same value.
        // it will save our from the repetition.
        if (tab[n - 1][sum] != -1) return tab[n - 1][sum];

        // If the value of a[n-1] is
        // greater than the sum.
        // we call for the next value
        if (a[n - 1] > sum) return tab[n - 1][sum] = subsetSum(a, n - 1, sum, tab);
        else {

            // Here we do two calls because we
            // don't know which value is
            // full-fill our criteria
            // that's why we doing two calls
            if (subsetSum(a, n - 1, sum, tab) != 0 || subsetSum(a, n - 1, sum - a[n - 1], tab) != 0) {
                return tab[n - 1][sum] = 1;
            } else return tab[n - 1][sum] = 0;
        }
    }

}
