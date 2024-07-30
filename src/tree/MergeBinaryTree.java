package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class MergeBinaryTree {

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


    private static List<List<String>> result = new ArrayList();

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList();
        binaryTreePath(root, res);
        res.clear();
        result.forEach(System.out::println);
        for(List<String> temp:result){
            String resStr="";
            for(String value:temp){
                resStr+=value+"->";
            }
            resStr=resStr.substring(0,resStr.length()-2);
            res.add(resStr);
        }
        return res;
    }

    public static void binaryTreePath(TreeNode root, List<String> res) {
        if (root == null) {
            return;
        }

        res.add(String.valueOf(root.val));

        if (root.left == null && root.right == null) {
            result.add(new ArrayList(res));
            res.removeLast();
            return;
        }

        binaryTreePath(root.left, res);
        binaryTreePath(root.right, res);

        res.removeLast();
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.right = new TreeNode(5);
        binaryTreePaths(node);
    }
}
