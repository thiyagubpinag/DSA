package array;

public class MinimumRotatedSortArray {
    public static int findMin(int[] nums) {
        int low = 0;
        int n = nums.length;
        int high = n - 1;
        if (nums[low] < nums[high]) {
            return nums[low];
        }
        if(nums[low]>nums[high]){
            return nums[high];
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                return nums[mid];
            } else if (nums[mid] > nums[low]) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1};
        int res = findMin(nums);
        System.out.println(res);
    }
}
