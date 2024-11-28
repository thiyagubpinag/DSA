package tree;

import java.util.HashMap;

public class ConstructBinTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inMap = new HashMap();
        for (int i = 0; i < inorder.length; i++)
            inMap.put(inorder[i], i);
        return buildTree(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1, inMap);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd, HashMap<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inMap.get(preorder[preStart]);
        int left = inRoot - inStart;
        root.left = buildTree(preorder, inorder, preStart + 1, preStart + left, inStart, inRoot - 1, inMap);
        root.right = buildTree(preorder, inorder, preStart + left + 1, preEnd, inRoot + 1, inEnd, inMap);
        return root;
    }

    public static void main(String[] args) {
        ConstructBinTree constructBinTree = new ConstructBinTree();
        int[] preOrder = {3, 9, 20, 15, 7};
        int[] inOrder = {9, 3, 15, 20, 7};
        TreeNode root=constructBinTree.buildTree(preOrder, inOrder);
        System.out.println(root);
    }
}
