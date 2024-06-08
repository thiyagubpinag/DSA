package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
class SubsetSumPrint {
    public int solve(int[] arr, int n, int k) {
        //Write your code here
        int sum=k;
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
            return -1;
        }

        ArrayList<Integer> list = new ArrayList<>();
        printSubsetSum(dp, arr, n - 1, sum, list);
        List<List<Integer>> distinctList = resultList.stream()
                .distinct()
                .collect(Collectors.toList());
        return distinctList.size();

    }
    private static List<List<Integer>> resultList = new ArrayList<>();

    private static void printSubsetSum(boolean[][] dp, int[] arr, int n, int sum, ArrayList<Integer> list) {

        if (n == 0 && sum != 0 && dp[0][sum]) {
            list.add(arr[n]);
            Collections.sort(list);
            resultList.add(list);
            return;
        }

        // If sum becomes 0
        if (n == 0 && sum == 0) {
            resultList.add(list.stream().sorted().toList());
            return;
        }

        if (dp[n - 1][sum]) {
            ArrayList<Integer> internalList = new ArrayList<>();
            internalList.addAll(list);
            printSubsetSum(dp, arr, n - 1, sum, internalList);
        }

        if (sum >= arr[n] && dp[n - 1][sum - arr[n]]) {
            list.add(arr[n]);
            printSubsetSum(dp, arr, n - 1, sum - arr[n], list);
        }

    }
}