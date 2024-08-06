package array;

public class MinSubArray {
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int n = nums.length;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (left < n && right < n) {
            sum += nums[right];
            while (sum >= target) {
                min = Math.min(min, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        while (left < right) {
            if (sum >= target) {
                min = Math.min(min, right - left);
            }
            sum -= nums[left];
            left++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        int[] a = {5, 1, 3, 5, 10, 7, 4, 9, 2, 8};
        int target = 8;
        int res = minSubArrayLen(target, a);
        System.out.println(res);
    }
}
