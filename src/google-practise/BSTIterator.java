public class BSTIterator {

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

    class LList {
        int key;
        LList next;

        LList(int key) {
            this.key = key;
        }
    }

    LList listRoot;

    public BSTIterator(TreeNode root) {
        listRoot = Iterator(root);
    }

    public LList Iterator(TreeNode root) {
        if (root == null) {
            return null;
        }

        // both are null
        LList l1 = new LList(root.val);
        LList left = Iterator(root.left);
        LList right = Iterator(root.right);

        if (left == null && right == null) {
            return l1;
        } else if (left == null && right != null) {
            l1.next = right;
            return l1;
        } else if (left != null && right == null) {
            left.next = l1;
            return left;
        } else {
            left.next = l1;
            l1.next = right;
            return left;
        }

    }

    public int next() {
        if (listRoot != null) {
            int res = listRoot.key;
            listRoot = listRoot.next;
            return res;
        }
        return -1;
    }

    public boolean hasNext() {
        return listRoot != null;
    }

    public static void main(String[] args) {

    }
}
