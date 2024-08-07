package practice;

public class ProdArray {

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] res = new int[n];
        prefix[0] = nums[0];
        suffix[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
            suffix[n - i - 1] = suffix[n - i] * nums[n - i - 1];
        }
        res[0] = suffix[1];
        for (int i = 1; i < n - 1; i++) {
            res[i] = prefix[i - 1] * suffix[i + 1];
        }
        res[n - 1] = prefix[n - 2];
        return res;
    }


    public static void main(String[] args) {
        productExceptSelf(new int[]{1, 2, 3, 4});
    }
}
