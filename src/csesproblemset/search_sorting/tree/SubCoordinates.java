package csesproblemset.search_sorting.tree;

import java.util.ArrayList;
import java.util.List;

public class SubCoordinates {
    static List<Node> nodeList = new ArrayList<>();

    static class Node {
        int data;
        List<Integer> children;

        public Node(int data) {
            this.data = data;
            this.children = new ArrayList<>();
        }
    }

    static void addNode(int from, int to) {
        nodeList.get(from).children.add(to);
    }

    public static void main(String[] args) {
        int n = 5;
        int[] a = {1, 1, 2, 3};
        for (int i = 0; i <= n; i++)
            nodeList.add(new Node(i));

        for (int i = 1; i < n; i++) {
            addNode(a[i - 1], i + 1);
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(dfs(i));
        }
    }

    static int dfs(int u) {
        Node node = nodeList.get(u);
        int res = 0;
        for (int i = 0; i < node.children.size(); i++) {
            res += dfs(node.children.get(i));
        }
        return res + node.children.size();
    }
}
