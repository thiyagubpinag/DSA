package dp;

import java.util.Arrays;

/* A Naive recursive implementation
of 0-1 Knapsack problem */
class Knapsack {

    static int knapSack(int W, int[] weight, int[] profit, int n, int[][] memo) {
        if (W <= 0 || n == -1) {
            return 0;
        }
        if(memo[n][W]!=-1) return memo[n][W];
        int ans;
        if (weight[n] > W) {
            ans=knapSack(W, weight, profit, n - 1, memo);
        } else {
            ans=Math.max(knapSack(W, weight, profit, n - 1, memo), profit[n] + knapSack(W - weight[n], weight, profit, n - 1, memo));
        }
        memo[n][W]=ans;
        return memo[n][W];
    }

    // Driver code
    public static void main(String args[]) {
        int profit[] = new int[]{60, 100, 120};
        int weight[] = new int[]{10, 20, 30};
        int W = 50;
        int n = profit.length;
        int[][] memo=new int[n][W+1];
        for(int i=0;i<n;i++){
            Arrays.fill(memo[i],-1);
        }
        System.out.println(knapSack(W, weight, profit, n-1,memo));
    }
}
/*This code is contributed by Rajat Mishra */
