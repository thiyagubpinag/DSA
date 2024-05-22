package array;

public class FlipAndInvertImage {
    public static int[][] flipAndInvertImage(int[][] image) {
        for(int i=0;i<image.length;i++){
            image[i]=reverseImage(image[i]);
            image[i]=invertImage(image[i]);
        }
        return image;
    }

    private static int[] invertImage(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                nums[i]=0;
            }else{
                nums[i]=1;
            }
        }
        return nums;
    }

    private static int[] reverseImage(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
        return nums;
    }

    public static void main(String[] args) {
         int[][] arr={{1,1,0},{1,0,1},{0,0,0}};
         int[][] res=flipAndInvertImage(arr);
         for(int i=0;i< res.length;i++){
             for(int j=0;j<res[i].length;j++){
                 System.out.print(res[i][j]+" ");
             }
             System.out.println();
         }
    }
}
