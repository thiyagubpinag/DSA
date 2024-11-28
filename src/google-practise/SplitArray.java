
public class SplitArray {
    public int splitArray(int[] nums, int k) {
        long high = 0l;
        int n = nums.length;
        long low = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            high += (nums[i]);
            low = Math.min(low, nums[i]);
        }
        int min = Integer.MAX_VALUE;
        high = 2 * high;
        while (low < high) {
            int mid = (int) (low + (high - low) / 2);
            int check = check(nums, mid, k);
            if (check != -1) {
                min = Math.min(min, check);
                high = mid;
            } else {
                low = mid + 1;
            }

        }

        return min;

    }

    private int check(int[] nums, int mid, int k) {

        int i = 0;
        int max = Integer.MIN_VALUE;

        while (i < nums.length) {
            int count = 0;
            int j = i;
            while (j < nums.length && count < mid) {
                count += nums[j];
                j++;
            }
            max = Math.max(max, count);
            i = j;
            k--;
            if (k < 0) {
                return -1;
            }

        }

        return k >= 0 ? max : -1;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        int k = 2;
        SplitArray splitArray = new SplitArray();
        int res = splitArray.splitArray(nums, k);
        System.out.println(res);
    }
}
