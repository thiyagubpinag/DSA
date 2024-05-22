package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TargetIndices {
    public static List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> resultList=new ArrayList<>();
        binarySearch(nums,target,0,nums.length-1,resultList);
        return resultList;
    }
    public static void binarySearch(int[] nums, int target, int left, int right, List<Integer> resultList){
        int mid=(left+right)/2;

        if(nums[mid]==target) {
            int l, r;
            l = r = mid;
            while (l >= 0) {
                if (nums[l] != target) {
                    break;
                }
                l--;
            }
            l+=1;
            while (r < nums.length) {
                if (nums[r] != target) {
                    break;
                }
                r++;
            }
            r-=1;
            for(int i=l;i<=r;i++){
                resultList.add(i);
            }
            return;
        }
        if(left>right){
            return;
        }
        if(nums[mid]>target){
            binarySearch(nums,target,left,mid-1, resultList);
        }
        binarySearch(nums,target,mid+1,right, resultList);
    }
    public static void main(String[] args) {
        int[] nums = {1};
        int target = 1;
        List<Integer> resultList=targetIndices(nums,target);
        System.out.println(resultList);
    }
}
