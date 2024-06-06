package dp;

public class MinSubsetDiff {
    public static void main(String[] args) {
        int n=3;
        int[] arr={2 ,9, 3};
        int res=minDifference(arr,n);
        System.out.println(res);
    }

    static int minDifference(int[] arr, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i];
        boolean[][] memo = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            memo[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                memo[i][j] = memo[i - 1][j];
                if (j - arr[i-1] >= 0) {
                    memo[i][j] = memo[i-1][j] || memo[i-1][j - arr[i-1]];
                }
            }
        }
        int count = 0;
        int mid = sum / 2;
        for (int i = mid; i >= 0; i--) {
            if (memo[n][i]) {
                count = sum - 2 * i;
                break;
            }
        }

        return count;


    }
}
