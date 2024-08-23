package com.cses;

public class MinimizeCoins {
    public static void main(String[] args) {
        int[] arr = {1, 5, 7,6};
        int sum = 11;
        int res = getMinimizeCoins(arr, sum);
        System.out.println(res);
    }

    private static int getMinimizeCoins(int[] arr, int sum) {
        if (sum == 0) {
            return 0;
        }
        if (sum < 0) {
            return -1;
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (getMinimizeCoins(arr, sum - arr[i]) != -1) {
                ans = Math.min(ans, 1 + getMinimizeCoins(arr, sum - arr[i]));
            }
        }
        return ans;
    }
}
