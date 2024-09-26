package dp;

import java.util.Arrays;

public class MatrixMultiplication {

    public static int mcm(int i, int j, int[] arr, int[][] dp){
        if(i>=j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int min=Integer.MAX_VALUE;

        for(int k=i;k<j;k++){
            int val=mcm(i,k,arr, dp)+mcm(k+1,j,arr, dp)+(arr[i-1]*arr[k]*arr[j]);
            min=Math.min(min,val);
        }

        return dp[i][j]=min;

    }


    public static void main(String[] args) {
        int N = 5;
        int[] arr = {2, 3, 2,4};
        int[][] dp=new int[arr.length][arr.length];
        for(int i=0;i< arr.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int val=mcm(1,arr.length-1,arr,dp);
        System.out.println(val);

    }

    // 2*3 3*2 2*4


}
