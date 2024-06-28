package graph;

import java.util.*;

public class TopologicalSort {

    // Driver code
    public static void main(String[] args) {
        // Number of nodes
        int V = 4;

        // Edges
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(0, 1));
        edges.add(Arrays.asList(1, 2));
        edges.add(Arrays.asList(3, 1));
        edges.add(Arrays.asList(3, 2));

        // Graph represented as an adjacency list
        List<List<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> i : edges) {
            adj.get(i.get(0)).add(i.get(1));
        }

        topologicalSort(adj, V);
    }

    private static void topologicalSort(List<List<Integer>> adj, int v) {
        boolean[] visited = new boolean[v];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                topologicalSort(v, i, adj, visited, stack);
            }
        }
        System.out.println(stack);
    }


    private static void topologicalSort(int v, int i, List<List<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[i] = true;
        for (int x = 0; x < adj.get(i).size(); x++) {
            if (!visited[x]) {
                topologicalSort(v, i, adj, visited, stack);
            }
        }
        stack.push(i);
    }
}
