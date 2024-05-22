package array;

public class BitManipulationPractise {
    public static int subsetXORSum(int[] nums) {
        return subsetXORSum(nums,0,0);
    }

    private static int subsetXORSum(int[] nums, int level, int xorSum) {
        if(level==nums.length){
            return xorSum;
        }

        int inc=subsetXORSum(nums,level+1,nums[level]^xorSum);
        int exc=subsetXORSum(nums,level+1,xorSum);
        return inc+exc;
    }

    public static void main(String[] args) {
        int[] nums = {5,1,6};
        int res=subsetXORSum(nums);
        System.out.println(res);
        System.out.println(2^2);
    }
}
