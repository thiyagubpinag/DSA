import javax.swing.tree.TreeNode;

public class PathSum {
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

    static int count = 0;

    public static void path(TreeNode root, int targetSum, int inPathSum) {
        if (root == null) {
            return;
        }

        if (root.val == targetSum || inPathSum == targetSum) {
            count++;
        }

        path(root.left, targetSum, inPathSum + root.val);
        path(root.left, targetSum, inPathSum);
        path(root.right, targetSum, inPathSum + root.val);
        path(root.right, targetSum, inPathSum);
    }

    public static int pathSum(TreeNode root, int targetSum) {
        count = 0;
        if (root == null) {
            return 0;
        }
        path(root, targetSum, 0);
        return count;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);

        PathSum pathSum = new PathSum();
        int res = pathSum(root, 8);
        System.out.println(res);

    }
}
