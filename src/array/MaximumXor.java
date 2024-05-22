package array;

public class MaximumXor {
    public static int[] getMaximumXor(int[] nums, int maximumBit) {
        int maxValue = (int) Math.pow(2, maximumBit) - 1;
        int[] temp = new int[nums.length];
        int previousXOR = 0;
        int revLength = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            previousXOR = previousXOR ^ nums[i];
            temp[revLength] = previousXOR ^ maxValue;
            revLength--;
        }
        return temp;
    }
    public static void main(String[] args) {
        int[] nums ={0,1,1,3};
        int maximumBit = 2;
        int[] result=getMaximumXor(nums,maximumBit);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
    }
}
