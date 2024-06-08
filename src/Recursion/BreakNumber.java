package Recursion;

public class BreakNumber {
    public static int solve(int n) {
        //Write your code here
        int mid = n / 2;
        mid=n%2==0?mid:mid+1;
        int[][] memo = new int[mid + 1][n + 1];
        for (int i = 0; i <= mid; i++) {
            for (int j = 0; j <= n; j++) {
                memo[i][j] = -1;
            }
        }
        int res = knapsack(mid, n, 1, memo);
        System.out.println(res);
        return res;
    }


    public static int knapsack(int n, int sum, int mul, int[][] memo) {
        if (n <= 0 || sum < 0) {
            return 0;
        }

        if (sum == 0) {
            return mul;
        }

        if (n > sum) {
            memo[n][sum] = knapsack(n - 1, sum, mul, memo);
        } else {
            memo[n][sum] = Math.max(knapsack(n, sum - n, mul * n, memo), knapsack(n - 1, sum, mul, memo));
        }

        return memo[n][sum];
    }

    public static void main(String[] args) {
        int n = 3;
        solve(n);
    }
}
