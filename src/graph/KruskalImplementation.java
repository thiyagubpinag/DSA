package graph;

import java.util.*;


public class KruskalImplementation {

    static class Node {
        int parent;
        int rank;

        Node(int parent, int rank) {
            this.parent = parent;
            this.rank = rank;
        }
    }

    static int[][] minimumSpanningTree(int n, int[][] edges) {
        Arrays.sort(edges, Comparator.comparing(i -> i[2]));
        List<Node> nodeList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            nodeList.add(new Node(-1, 0));
        }

        return unionAdd(nodeList, edges, n);
    }

    private static int[][] unionAdd(List<Node> nodeList, int[][] edges, int n) {
        int[][] result = new int[n-1][3];
        int i = 0;
        for (int[] edge : edges) {
            if (i < n - 1) {
                int start = findParent(edge[0], nodeList);
                int end = findParent(edge[1], nodeList);
                if (start != end) {
                    pathCompressionByRank(nodeList, start, end);
                    result[i++] = edge;
                }
            }
        }
        return result;
    }

    private static void pathCompressionByRank(List<Node> nodeList, int start, int end) {
        Node startNode = nodeList.get(start);
        Node endNode = nodeList.get(end);

        if (startNode.rank > endNode.rank) {
            endNode.parent = start;
        } else if (startNode.rank < endNode.rank) {
            startNode.parent = end;
        } else {
            endNode.parent = start;
            endNode.rank++;
        }

    }

    private static int findParent(int x, List<Node> nodeList) {
        Node parentNode = nodeList.get(x);
        if (parentNode.parent == -1) {
            return x;
        }
        int parent = findParent(parentNode.parent, nodeList);
        parentNode.parent = parent;
        nodeList.set(x, parentNode);
        return nodeList.get(x).parent;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arrStr1 = sc.nextLine().split(" ");
        int n = Integer.parseInt(arrStr1[0]);
        int m = Integer.parseInt(arrStr1[1]);
        int[][] arr = new int[m][3];
        for (int i = 0; i < m; i++) {
            String[] arrStr = sc.nextLine().split(" ");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(arrStr[j]);
            }
        }
        int[][] result = minimumSpanningTree(n, arr);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
