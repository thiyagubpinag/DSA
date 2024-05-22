package array;

public class PivotIndex {
    public static int pivotIndex(int[] nums) {
        int left=0;
        int right=0;
        for(int i=1;i<nums.length;i++){
            right+=nums[i];
        }

        for(int i=0;i<nums.length-1;i++){
            if(left==right){
                return i;
            }
            left+=nums[i];
            right-=nums[i+1];
        }

        return left==0?nums.length-1:-1;
    }
    public static void main(String[] args) {
        int res=pivotIndex(new int[]{-1,-1,0,1,1,0});
        System.out.println(res);
    }
}
