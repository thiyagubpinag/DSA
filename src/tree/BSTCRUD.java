package tree;

public class BSTCRUD {
    static TreenNode root;

    static class TreenNode {
        int data;
        TreenNode left;
        TreenNode right;

        public TreenNode(int data) {
            this.data = data;
        }
    }


    public static void main(String[] args) {
        root = new TreenNode(5);

        insertNode(root, 2);
        insertNode(root, 3);
        insertNode(root, 1);
        insertNode(root, 7);
        insertNode(root, 6);
        insertNode(root, 4);
        insertNode(root, 8);
        insertNode(root, 9);
        insertNode(root, 10);

        inorderRoot(root);

        System.out.println();

        deleteNode(root, 5);

        inorderRoot(root);

    }

    private static TreenNode deleteNode(TreenNode root, int data) {
        if (root == null) {
            return root;
        }
        if (root.data > data) {
            root.left = deleteNode(root.left, data);
        } else if (root.data < data) {
            root.right = deleteNode(root.right, data);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            //inorder successor
            root.data = minData(root.right, data);

            root.right = deleteNode(root.right, root.data);

        }

        return root;

    }

    private static int minData(TreenNode right, int data) {
        int min = Integer.MAX_VALUE;
        TreenNode temp = right;
        while (temp != null) {
            min = Math.min(min, temp.data);
            temp = temp.left;
        }
        return min;
    }

    private static void inorderRoot(TreenNode root) {
        if (root == null) {
            return;
        }
        inorderRoot(root.left);
        System.out.print(root.data + ",");
        inorderRoot(root.right);
    }

    private static TreenNode insertNode(TreenNode root, int data) {
        if (root == null) {
            root = new TreenNode(data);
            return root;
        }
        if (root.data > data) {
            root.left = insertNode(root.left, data);
        } else {
            root.right = insertNode(root.right, data);
        }
        return root;
    }
}
