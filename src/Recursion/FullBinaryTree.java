package Recursion;

import java.util.Arrays;

public class FullBinaryTree {
    static class TreeNode {
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
    public static void main(String[] args) {
        int[] a={1,2,3,4};
        int[] b=Arrays.copyOfRange(a,0,2);
        int[] c=Arrays.copyOfRange(a,2,a.length);
        System.out.println("done");
    }
}
