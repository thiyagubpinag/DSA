
public class DeleteNode {

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

    public TreeNode findNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val == key) {
            return root;
        }

        TreeNode left = findNode(root.left, key);

        if (left != null) {
            return left;
        }

        TreeNode right = findNode(root.right, key);

        if (right != null) {
            return right;
        }

        return null;

    }

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode found = findNode(root, key);

        if (found.right == null && found.left == null) {

        } else if (found.left == null) {
            found = found.right;
        } else {
            TreeNode temp = found;
            temp = temp.right;
            TreeNode prev = temp;
            while (temp.left != null) {
                prev = temp;
                temp = temp.left;
            }
            found.val = temp.val;
            prev.left = null;
        }

        return root;
    }

    public static void main(String[] args) {

    }
}
