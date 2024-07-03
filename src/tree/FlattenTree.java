package tree;

public class FlattenTree {
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

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flattenNode(root);


    }

    public TreeNode flattenNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftNode = flattenNode(root.left);
        TreeNode rightNode = flattenNode(root.right);
        TreeNode prev = leftNode;
        TreeNode temp = leftNode;
        while (temp != null) {
            prev = temp;
            temp = temp.right;
        }
        if (prev != null && rightNode != null) {
            prev.right = rightNode;
            root.right = leftNode;
            root.left = null;
        } else if (prev != null) {
            root.right = leftNode;
            root.left = null;
        }
        return root;
    }

    public static void main(String[] args) {
        FlattenTree a = new FlattenTree();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(5);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.right.right = new TreeNode(6);
        a.flatten(node);
    }
}
