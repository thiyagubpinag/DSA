package array;

public class CountNegatives {
    public static int countNegatives(int[][] grid) {
        int sum=0;
         for(int i=0;i<grid.length;i++){
             int index=binarySearchCount(grid[i],0,grid[i].length-1);
             if(index!=-1) {
                 sum += (grid[i].length - index);
             }
         }
         return sum;
    }

    private static int binarySearchCount(int[] nums, int low, int high) {
        int mid=(low+high)/2;
        if(nums[mid]<0){
            if(mid>0){
                if(nums[mid-1]>=0){
                    return mid;
                }else{
                    return binarySearchCount(nums,low,mid-1);
                }
            }else{
                return mid;
            }
        }
        if(low>high){
            return -1;
        }
        return binarySearchCount(nums,mid+1,high);
    }

    public static void main(String[] args) {
        int[][] grid = {{3,-1,-3,-3,-3},{2,-2,-3,-3,-3},{1,-2,-3,-3,-3},{0,-3,-3,-3,-3}};
        int ress=countNegatives(grid);
        System.out.println(ress);

    }
}
