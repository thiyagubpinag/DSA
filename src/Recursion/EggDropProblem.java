package Recursion;

import java.util.Arrays;

public class EggDropProblem {
    static int[][] dp;
    public static int eggDrop(int n, int k) {
        if (k == 1 || k == 0) return k;

        if (n == 1) return k;

        if(dp[n][k]!=-1){
            return dp[n][k];
        }

        int min = Integer.MAX_VALUE;
        int x, res;

        for (x = 1; x <= k; x++) {
            res = Math.max(eggDrop(n - 1, x - 1), eggDrop(n, k - x));
            if (res < min) min = res;
        }

        return dp[n][k]=min + 1;

    }

    public static void main(String[] args) {
        int n = 2, k = 10;
        dp=new int[n+1][k+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println(eggDrop(n,k));
    }

}
