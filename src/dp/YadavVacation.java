package dp;

public class YadavVacation {

    public static int countVacationDays(int[] weather, int n, int k, int t) {
        int[][] dp = new int[n][n];

        // Base cases
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Build the DP table
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (weather[i] <= t) {
                    dp[i][j] = dp[i + 1][j]; // Choose day i only if valid from i+1
                    if (j - i + 1 >= k && weather[i] <= t) {
                        dp[i][j] += dp[i + k][j]; // Include day i if k consecutive days valid from i+k
                    }
                }
            }
        }

        // Count vacations with at least k consecutive days
        int count = 0;
        for (int i = 0; i <= n - k; i++) {
            count += dp[i][i + k - 1];
        }

        return count;
    }

    public static void main(String[] args) {
        int[] weather = {-5, 0, -10};
        int n = 3;
        int k = 1;
        int t = 15;

        int vacationDays = countVacationDays(weather, n, k, t);
        System.out.println("Number of vacation days: " + vacationDays);
    }
}

