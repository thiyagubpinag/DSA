package dp;

public class ChocolatePartition {

    public static int countPartitions(int[] nums, int d) {
        int mod = 1000000007;
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // Check for invalid cases
        if (totalSum < d || (totalSum - d) % 2 != 0) {
            return 0;
        }

        int targetSum = (totalSum + d) / 2;
        int[] dp = new int[targetSum + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int j = targetSum; j >= num; j--) {
                dp[j] = (dp[j] + dp[j - num]) % mod;
            }
        }

        return dp[targetSum];
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 6, 4};
        int d = 3;
        int count = countPartitions(nums, d);
        System.out.println("Number of ways to partition: " + count);
    }
}
