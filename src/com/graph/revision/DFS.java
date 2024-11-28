package com.graph.revision;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    static void addEdge(List<List<Integer>> adj, int s, int t) {
        // Add edge from vertex s to t
        adj.get(s).add(t);
        // Due to undirected Graph
        adj.get(t).add(s);
    }

    public static void main(String[] args) {
        int V = 6; // Number of vertices in the graph

        // Create an adjacency list for the graph
        List<List<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Define the edges of the graph
        int[][] edges
                = { { 1, 2 }, { 2, 0 }, { 0, 3 }, { 4, 5 } };

        // Populate the adjacency list with edges
        for (int[] e : edges) {
            addEdge(adj, e[0], e[1]);
        }

        int source = 1;
        System.out.println("DFS from source: " + source);
        DFSUtil(adj, source, V);
    }

    private static void DFSUtil(List<List<Integer>> adj, int source, int v) {
        boolean[] visited = new boolean[v];

        for (int i = 0; i < v; i++) {
            if(!visited[i]) {
                dfsCall(adj, i, visited);
            }
        }

    }

    private static void dfsCall(List<List<Integer>> adj, int i, boolean[] visited) {

        visited[i] = true;
        System.out.println(i);
        for (Integer v : adj.get(i)) {
            if (!visited[v]) {
                dfsCall(adj, v, visited);
            }
        }
    }
}
