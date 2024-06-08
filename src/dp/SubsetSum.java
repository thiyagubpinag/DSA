package dp;

import java.util.*;
import java.util.stream.IntStream;

public class SubsetSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 3};
        int k = 4;
        int n = arr.length;
        int[][] dp = new int[n + 1][k + 1];

        // Base cases
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1; // One way to reach 0 (using no gifts)
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                // Exclude the current gift
                dp[i][j] = dp[i - 1][j];

                // Include the current gift if possible
                if (arr[i - 1] <= j) {
                    dp[i][j] += dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        System.out.println(dp[n][k]);
    }

    static int count=0;

    public static void combinationUtil(int arrA[] , int sum, int currSum, int start, List<Integer> combinationList){

        if(currSum==sum) {
            count++;
            return;
        }

        int prevElement = -1;
        for (int i = start; i <arrA.length ; i++) {
            if(prevElement!=arrA[i]) {
                if(currSum+arrA[i]>sum) //array is sorted, no need to check further
                    break;
                combinationList.add(arrA[i]);
                combinationUtil(arrA, sum, currSum + arrA[i], i + 1, combinationList);
                combinationList.remove(combinationList.size() - 1);
                prevElement = arrA[i];
            }
        }
    }

}
