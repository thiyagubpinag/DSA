public class BurstBallons {
    public int find(int[] nums, int i, int j) {
        if (i > j) {
            return 0;
        }

        int max = Integer.MIN_VALUE;

        for (int k = i; k <= j; k++) {
            int cost = (nums[i - 1] * nums[k] * nums[j + 1]) + find(nums, i, k - 1) + find(nums, k + 1, j);
            max = Math.max(cost, max);
        }

        return max;

    }

    public int maxCoins(int[] nums) {
        int[] input = new int[nums.length + 2];

        input[0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            input[i] = nums[i - 1];
        }
        input[nums.length + 1] = 1;
        return find(input, 1, nums.length);
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, 5, 8 };
        BurstBallons burstBallons = new BurstBallons();
        int res = burstBallons.maxCoins(nums);
        System.out.println(res);
    }
}
