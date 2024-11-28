package dp.practise;

import java.util.Arrays;

public class MinimumCoins {
    static int count=0;
    public static void main(String[] args) {
        int[] a={1,2,3,4,5,6};
        int sum=3;
        int[][] dp=new int[a.length+1][sum+1];
        for(int i=0;i<=a.length;i++){
            Arrays.fill(dp[i],-1);
        }
        minimumCoins(a,sum,a.length-1,dp);
        System.out.println(count);

    }

    private static void minimumCoins(int[] a, int sum, int n, int[][] dp) {
        if(n<0 || sum<0){
            return;
        }

        if(sum==0){
            count++;
            return;
        }

        if(a[n]>sum){
            minimumCoins(a, sum, n - 1, dp);
        }else {
            minimumCoins(a, sum, n - 1, dp);
            minimumCoins(a, sum - a[n], n, dp);
        }

    }
}
