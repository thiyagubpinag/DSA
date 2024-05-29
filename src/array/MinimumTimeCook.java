package array;

import java.util.Arrays;

public class MinimumTimeCook {
    public static void main(String[] args) {
        int arr[] = {1, 4};
        int m = 6;
        int min = Integer.MAX_VALUE;
        int n = arr.length;
        for (int i = 0; i < n; i++)
            min = Math.min(min, arr[i]);

        int low = 0;
        int high = min * m;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (getOutputValue(arr, mid, m)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(low);
        int[][] memo=new int[n][m+1];
        for(int i=0;i<n;i++){
            Arrays.fill(memo[i],-1);
        }
        minTimeCook(arr, n - 1, m, 0,memo);
        System.out.println(minVal);

    }

    static int minVal = Integer.MAX_VALUE;

    private static void minTimeCook(int[] arr, int n, int m, int level,int[][] memo) {
        if (n < 0) {
            return;
        }
        if (m == 0) {
            minVal = Math.min(minVal, level);
            return;
        }
        minTimeCook(arr, n, m - 1, level + arr[n],memo);
        minTimeCook(arr, n - 1, m, level,memo);


    }

    private static boolean getOutputValue(int[] arr, int mid, int m) {
        int res = 0;
        for (int i = 0; i < arr.length; i++)
            res += (mid / arr[i]);

        return res >= m;
    }
}
