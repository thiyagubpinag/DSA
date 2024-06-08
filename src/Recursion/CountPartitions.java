package Recursion;

public class CountPartitions {
    public static int countPartitions(int n, int d, int[] arr) {
        //Write your code here
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
                if (j - arr[i - 1] >= 0) {
                    memo[i][j] = memo[i - 1][j] || memo[i - 1][j - arr[i - 1]];
                }
            }
        }
        int count = 0;
        for (int i = 1; i <= sum - d; i++) {
            if (memo[n][i] && memo[n][i + d]) {
                count++;
            }
        }
        return count;

    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 6, 4};
        int n = 4;
        int d = 3;
        int res = countPartitions(n, d, arr);
        System.out.println(res);
    }
}
