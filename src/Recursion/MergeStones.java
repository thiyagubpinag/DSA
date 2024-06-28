package Recursion;
import java.util.*;
public class MergeStones {
    public static int mergeStones(int[] stones, int k) {
        if((stones.length-1)%(k-1) !=0)return -1;

        int[][] dp=new int[stones.length+1][stones.length+1];
        for(int[] d : dp){
            Arrays.fill(d,-1);
        }
        return helper(stones,0,stones.length-1,k,dp);
    }

    public static int helper(int[] stones, int i, int j, int k, int[][] dp){
        if(i>=j)return 0;

        if(dp[i][j]!=-1)return dp[i][j];
        int min=Integer.MAX_VALUE;
        System.out.println(i+","+j);
        for(int n = i; n < j; n +=k-1){
            System.out.println(i+","+j);
            int ans = helper(stones, i, n, k,dp) + helper(stones, n+1, j, k,dp);
            min = Math.min(ans, min);
        }
        System.out.println(i+","+j);
        if(min!=Integer.MAX_VALUE&&((j-i)%(k-1))==0){
            for(int n = i; n <= j; n++){
                min+=stones[n];
            }
        }
        return dp[i][j]=min;
    }

    public static void main(String[] args) {
        int[] stones = {3, 5, 1, 2,6};
        int k = 3;
        int res = mergeStones(stones, k);
        System.out.println(res);
    }

}
