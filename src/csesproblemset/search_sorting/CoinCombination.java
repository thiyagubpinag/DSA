package csesproblemset.search_sorting;

import java.util.Arrays;

public class CoinCombination {
    static int count = 0;

    static int coinCombination(int n, int sum, int[] coins, int[] dp) {
        if (sum < 0) {
            return 0;
        }
        if (sum == 0) {
            return 1;
        }
        if(dp[sum]!=-1){
            return dp[sum];
        }
        int temp=0;
        for (int i = 0; i < n; i++) {
            temp+=coinCombination(n, sum - coins[i], coins, dp);
        }
        return dp[sum]=temp;
    }

    public static void main(String[] args) {
        int N = 3, X = 9;
        int[] coins = {2, 3, 5};
        int[] dp=new int[X+1];
        Arrays.fill(dp,-1);
        int res=coinCombination(N, X, coins,dp);
        System.out.println(res);

    }
}
