package Recursion;

public class MaxBinaryTree {

        public static int getMaxValue(int[] nums,int left,int right){
            int max=Integer.MIN_VALUE;
            int index=-1;
            for(int i=left;i<=right;i++){
                if(max<nums[i]){
                    max=nums[i];
                    index=i;
                }
            }
            return index;
        }
        public static FullBinaryTree.TreeNode constructMaximumBinaryTree(int[] nums) {
            int n=nums.length;
            return constructMaximumBinaryTree(nums,0,n-1);
        }

        public static FullBinaryTree.TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
            int n=end-start;
            if(n<0){
                FullBinaryTree.TreeNode node=null;
                return node;
            }
            int index=getMaxValue(nums,start,end);
            FullBinaryTree.TreeNode node=new FullBinaryTree.TreeNode(nums[index]);
            node.left=constructMaximumBinaryTree(nums,start,index-1);
            node.right=constructMaximumBinaryTree(nums,index+1,end);
            return node;
        }

    public static void main(String[] args) {
        FullBinaryTree.TreeNode node=constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
        System.out.println(node);
    }
}
