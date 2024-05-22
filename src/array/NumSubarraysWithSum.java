package array;

public class NumSubarraysWithSum {
    public static void main(String[] args) {
        int[] nums = {0,1,1,1,1};
        int goal = 3;
        int res = numSubarraysWithSum(nums, goal);
        System.out.println(res);
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        int total;
        int[] left = new int[nums.length + 1];
        int[] right = new int[nums.length + 1];

        left[0] = 0;
        right[nums.length] = 0;
        for (int i = 0; i < nums.length; i++) {
            left[i + 1] = left[i] + nums[i];
            right[nums.length - i - 1] = right[nums.length - i] + nums[nums.length - i-1];
        }
        total = right[0];
        int count = 0;
        for (int k = 1; k <= nums.length; k++) {
            for (int i = 0; i < nums.length - k + 1; i++) {
                int j = i + k - 1;
                if (total - left[i] - right[j + 1] == goal) {
                    count++;
                }
            }
        }

        return count;
    }
}
