package array;

public class GetMaximumGenerated {
    public static int getMaximumGenerated(int n) {
        int[] nums = new int[n + 1];
        nums[0] = 0;
        if (n == 0) {
            return 0;
        }
        nums[1] = 1;
        int max = 1;
        int sum;
        int index = 2;
        for (int i = 1; i <= n / 2; i++) {
            nums[index++] = nums[i];
            max = Math.max(nums[i], max);
            if(index>=n+1){
                break;
            }
            sum = 0;
            for (int j = i; j <= i + 1; j++) {
                sum += nums[j];
            }
            nums[index++] = sum;
            max = Math.max(sum, max);
            if(index>=n+1){
                break;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int res = getMaximumGenerated(4);
        System.out.println(res);
    }
}
