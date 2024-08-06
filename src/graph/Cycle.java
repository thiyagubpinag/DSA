package graph;

import java.util.*;

public class Cycle {
    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        graph.add(new ArrayList<>(List.of(0, 1)));
        graph.add(new ArrayList<>(List.of(1, 2)));
        graph.add(new ArrayList<>(List.of(0, 2)));
        //graph.add(new ArrayList<>(List.of(0, 3)));

        boolean res = hasValidPath(graph, 0, 2);
        System.out.println(res);
    }

    static class Node {
        int parent;
        int rank;

        public Node(int parent, int rank) {
            this.parent = parent;
            this.rank = rank;
        }
    }

    private static int findParent(Integer i, List<Node> nodeList) {
        if (nodeList.get(i).parent == -1) {
            return i;
        }
        int value = findParent(nodeList.get(i).parent, nodeList);
        Node node = nodeList.get(i);
        node.parent = value;
        nodeList.set(i, node);
        return value;
    }

    public static boolean hasValidPath(List<List<Integer>> graph, int source, int destination) {
        //Write your code here
        int n = graph.size();
        List<Node> nodeList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Node node = new Node(-1, 0);
            nodeList.add(node);
        }
        return isCyclic(graph, nodeList);
    }

    static boolean isCyclic(List<List<Integer>> graph, List<Node> nodeList) {
        for (List<Integer> p : graph) {
            int fromP = findParent(p.get(0), nodeList);    //FIND absolute parent of subset
            int toP = findParent(p.get(1), nodeList);

            if (fromP == toP) return false;

            //UNION operation
            unionNode(fromP, toP, nodeList);    //UNION of 2 sets
        }
        return false;
    }

    private static void unionNode(int from, int to, List<Node> nodeList) {
        Node fromNode = nodeList.get(from);
        Node toNode = nodeList.get(to);

        if (fromNode.rank < toNode.rank) {
            fromNode.parent = to;
        } else if (fromNode.rank > toNode.rank) {
            toNode.parent = from;
        } else {
            fromNode.parent = to;
            toNode.rank++;
        }

    }
}



