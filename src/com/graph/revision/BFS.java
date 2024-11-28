package com.graph.revision;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    // Function to add an edge to the graph
    static void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void main(String[] args) {
        // Number of vertices in the graph
        int V = 5;

        // Adjacency list representation of the graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges to the graph
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 4);

        // Mark all the vertices as not visited
        boolean[] visited = new boolean[V];

        // Perform BFS traversal starting from vertex 0
        System.out.println("BFS starting from 0 : ");
        bfs(adj, 0, visited, V);
    }

    private static void bfs(List<List<Integer>> adj, int u, boolean[] visited, int v) {
        int step = 1;
        int[] level = new int[v];
        int[] parent = new int[v];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(u);
        parent[u] = -1;
        level[u] = 0;
        visited[u] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Integer uTemp = queue.poll();
                for (Integer vTemp : adj.get(uTemp)) {
                    if (!visited[vTemp]) {
                        queue.add(vTemp);
                        visited[vTemp] = true;
                        level[vTemp] = step;
                        parent[vTemp] = uTemp;
                    }
                }
            }
            step++;
        }
        System.out.println("Done");

    }
}
