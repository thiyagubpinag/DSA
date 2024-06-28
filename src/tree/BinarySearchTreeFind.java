package tree;

public class BinarySearchTreeFind {
    static class Node {
        int data;
        Node left, right;

        public Node(final int d) {
            data = d;
        }
    }


    public static void main(String[] args) {

        /* Let us construct the following Tree
         60
        /  \
       65  70
      /
     50 */

        final Node node1 = new Node(60);
        node1.left = new Node(65);
        node1.right = new Node(70);
        node1.left.left = new Node(50);

        System.out.print("Size of the largest BST is " + BinarySearchTreeFind.largestBst(node1) + "\n");
    }

    static int MAX = Integer.MAX_VALUE;
    static int MIN = Integer.MIN_VALUE;

    static class nodeInfo {
        int size; // Size of subtree
        int max; // Min value in subtree
        int min; // Max value in subtree
        boolean isBST; // If subtree is BST

        nodeInfo() {
        }

        nodeInfo(int size, int max, int min, boolean isBST) {
            this.size = size;
            this.max = max;
            this.min = min;
            this.isBST = isBST;
        }
    }

    private static int largestBst(Node root) {
        nodeInfo nodeIn = largestBs(root);
        return nodeIn.size;
    }

    private static nodeInfo largestBs(Node root) {
        if (root == null) {
            return new nodeInfo(0, MIN, MAX, true);
        }

        nodeInfo left = largestBs(root.left);
        nodeInfo right = largestBs(root.right);
        nodeInfo result = new nodeInfo();
        result.min = Math.min(left.min, root.data);
        result.max = Math.max(right.max, root.data);
        result.isBST = left.isBST && right.isBST && (root.data > left.max) && (root.data < right.min);

        if (result.isBST) {
            result.size = left.size + right.size + 1;
        } else {
            result.size = Math.max(left.size, right.size);
        }

        return result;

    }

}
