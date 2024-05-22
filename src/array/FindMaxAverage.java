package array;

public class FindMaxAverage {
    public static double findMaxAverage(int[] nums, int k) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                left[i] = nums[i];
                right[nums.length - i - 1] = nums[nums.length - i - 1];
            } else {
                left[i] = left[i - 1] + nums[i];
                right[nums.length - i - 1] = right[nums.length - i] + nums[nums.length - i - 1];
            }
        }
        int totalSum = right[0];
        Double maxSum = Double.MIN_VALUE;
        int remainingSum;
        if(nums.length==k){
            return (double) totalSum /k;
        }
        for (int i = 0; i + k <= nums.length; i++) {
            if (i == 0) {
                remainingSum = totalSum - right[i + k];
            } else if (i + k == nums.length) {
                remainingSum = totalSum - left[nums.length - k - 1];
            } else {
                remainingSum = totalSum - left[i - 1] - right[i + k];
            }

            maxSum = Math.max(maxSum, (double) remainingSum / k);
        }
        return maxSum;

    }

    public static void main(String[] args) {
        int[] nums = {4,0,4,3,3};
        int k = 5;
        double maxAverage = findMaxAverage(nums, k);
        System.out.println(maxAverage);

    }

}
