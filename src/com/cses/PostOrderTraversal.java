package com.cses;

import java.util.HashMap;

public class PostOrderTraversal {
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

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1, map);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder, int inLeft, int inRight, int postLeft, int postRight, HashMap<Integer, Integer> map) {
        if (inLeft > inRight || postLeft > postRight) return null;
        TreeNode root = new TreeNode(postorder[postRight]);
        int noOfLeft = map.get(postorder[postRight]);
        int left = noOfLeft - inLeft;
        root.left = buildTree(inorder, postorder, inLeft, inLeft + left - 1, postLeft, postLeft + left - 1, map);
        root.right = buildTree(inorder, postorder, inLeft + left+1, inRight, postLeft + left, postRight - 1, map);
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode root=buildTree(inorder, postorder);
        System.out.println("Done");
    }
}
