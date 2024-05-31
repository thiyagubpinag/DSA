package dp;

public class MaxMeritPoints {

    public static int maxMeritPoints(int[][] meritPoints) {
        int n = meritPoints.length;
        int[][] dp = new int[n][3]; // DP table

        // Base cases for day 1
        for (int j = 0; j < 3; j++) {
            dp[0][j] = meritPoints[0][j];
        }

        // Fill the DP table from day 2 onwards
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Math.max(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]) + meritPoints[i][j];
            }
        }

        // Find the maximum merit points from the last day
        int maxPoints = Integer.MIN_VALUE;
        for (int j = 0; j < 3; j++) {
            maxPoints = Math.max(maxPoints, dp[n - 1][j]);
        }

        return maxPoints;
    }

    public static void main(String[] args) {
        int[][] meritPoints = {
                {1, 2, 5},
                {3, 1, 1},
                {3, 3, 3}
        };

        int maxPoints = maxMeritPoints(meritPoints);
        System.out.println("Maximum Merit Points: " + maxPoints);
    }
}

