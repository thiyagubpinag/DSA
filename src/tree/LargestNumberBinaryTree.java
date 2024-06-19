package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class LargestNumberBinaryTree {

    static List<String> result=new ArrayList();
    public static void Concatenate(Node root) {
        //Write your code here
        printInorder(root);
        result.stream().sorted().toList().reversed();
        result.forEach(i-> System.out.print(i));
    }

    public static void printInorder(Node node)
    {
        if (node == null)
            return;
        printInorder(node.left);
        result.add(String.valueOf(node.data));
        printInorder(node.right);
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(34);
        root.right = new Node(47);
        root.left.left = new Node(6);

        Concatenate(root);

        System.out.println();
        String[] s = {"2", "11211", "4", "1129"};
        Arrays.sort(s, Comparator.comparing(String::valueOf));
        List<String> tempList = Arrays.stream(s).collect(Collectors.toList()).stream().sorted().collect(Collectors.toList()).reversed();
        result.stream().sorted().collect(Collectors.toList()).reversed();

        tempList.forEach(System.out::println);
    }

}
