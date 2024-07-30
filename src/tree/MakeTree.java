package tree;

import java.util.Arrays;

public class MakeTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        int index = Arrays.binarySearch(nums, 0);
        if (index < 0) {
            index = -(index) - 1;
        }
        System.out.println(index);
        return null;
    }

    public static void main(String[] args) {
        int[] arr = {-10, -3, -9,1, 5, 9};
        sortedArrayToBST(arr);
    }
}
