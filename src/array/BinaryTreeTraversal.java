package array;

import java.util.Arrays;

public class BinaryTreeTraversal {
    static class Node {
        char data;
        Node left;
        Node right;

        public Node(char data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static int index = 0;

    public static Node formTree(char[] pre, char[] in, int left, int right, Node root) {
        if (validCheck(left, right, pre.length) && index < pre.length) {
            if (root == null) {
                root = new Node(pre[index]);
            }
            int indexTo = getIndex(in, left, right, pre[index]);
            index++;
            if (indexTo != -1) {
                root.left = formTree(pre, in, left, indexTo - 1, null);
                root.right = formTree(pre, in, indexTo + 1, right, null);
            }
        }
        return root;
    }

    private static boolean validCheck(int left, int right, int length) {
        return left >= 0 && left < length && right >= 0 && right < length && left <= right;
    }

    private static int getIndex(char[] in, int left, int right, char c) {
        for (int i = left; i <= right; i++) {
            if (in[i] == c) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        char[] pre = {'A', 'B', 'D', 'E', 'C', 'F', 'G'};
        char[] in = {'D', 'B', 'E', 'A', 'F', 'C', 'G'};
        Node root = formTree(pre, in, 0, pre.length - 1, null);
        System.out.println("Done");

    }
}
