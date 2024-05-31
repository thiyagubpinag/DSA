package dp;

import java.util.Arrays;

public class MaxCoins_I {
    public static int maxCoins_I(int n, int[] arr) {
        int sum=0;
        for(int item:arr){
            sum+=item;
        }
        int[][] memo=new int[n][sum];
        for(int i=0;i<n;i++){
            Arrays.fill(memo[i],-1);
        }
        return maxCoins_I(arr,n-1,0,memo);
    }

    public static int maxCoins_I(int[] arr,int n,int sum,int[][] memo) {
        if(n<0){
            return sum;
        }

        if(memo[n][sum]!=-1){
            return memo[n][sum];
        }

        memo[n][sum]=Math.max(maxCoins_I(arr,n-2,sum+arr[n],memo),maxCoins_I(arr,n-1,sum,memo));
        return memo[n][sum];

    }

    public static void main(String[] args) {
        int[] arr={2, 7, 9, 3, 1};
        System.out.println(maxCoins_I(arr.length,arr));
    }
}
