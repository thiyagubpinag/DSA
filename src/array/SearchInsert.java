package array;

public class SearchInsert {
    public static int searchInsert(int[] nums, int target) {
         return binarySearchInsert(nums,target,0,nums.length-1);
    }

    private static int binarySearchInsert(int[] nums, int target, int low, int high) {
        if(low>high){
            return low;
        }
        int mid=(low+high)/2;
        if(nums[mid]==target){
            return mid;
        }
        if(nums[mid]>target){
            return binarySearchInsert(nums,target,low,mid-1);
        }
        return binarySearchInsert(nums,target,mid+1,high);
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 7;
        System.out.println(searchInsert(nums,target));
    }
}
