package dp;

import java.util.ArrayList;

public class PrintSubsetSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};

        int sum = 7;
        int n = arr.length;
        boolean[][] dp = new boolean[n][sum + 1];
        for (int i = 0; i < n; ++i) {
            dp[i][0] = true;
        }

        // Sum arr[0] can be achieved with single element
        if (arr[0] <= sum) dp[0][arr[0]] = true;

        // Fill rest of the entries in dp[][]
        for (int i = 1; i < n; ++i)
            for (int j = 0; j < sum + 1; ++j)
                dp[i][j] = (arr[i] <= j) ? (dp[i - 1][j] || dp[i - 1][j - arr[i]]) : dp[i - 1][j];
        if (dp[n - 1][sum] == false) {
            System.out.println("There are no subsets with" + " sum " + sum);
            return;
        }

        printSubset(new ArrayList<>(), dp, n - 1, sum, arr);

    }

    private static void printSubset(ArrayList<Integer> result, boolean[][] dp, int n, int sum, int[] arr) {
        if (n < 0 || sum < 0) {
            return;
        }

        if (n == 0) {
            if (dp[0][sum] == true) {
                result.add(arr[0]);
            }
            System.out.println(result);
            return;
        }

        if (sum == 0) {
            System.out.println(result);
            return;
        }

        if (dp[n - 1][sum]) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.addAll(result);
            printSubset(temp, dp, n - 1, sum, arr);
        }

        if (sum >= arr[n]) {
            result.add(arr[n]);
            printSubset(result, dp, n - 1, sum - arr[n], arr);
        }


    }
}
