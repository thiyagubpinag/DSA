package array;

import java.util.Arrays;

public class SortedSquares {
    public static int[] sortedSquares(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            if(left==right){
                nums[left]=Math.abs(nums[left]*nums[left]);
                break;
            }
            nums[left]=Math.abs(nums[left]*nums[left]);
            nums[right]=Math.abs(nums[right]*nums[right]);
            left++;
            right--;
        }
        Arrays.sort(nums);
        return nums;
    }

    public static void main(String[] args) {
        int[] res=sortedSquares(new int[]{-7,-3,2,3,11});
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }
}
