package com.graph.revision;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PrintAllPaths {
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
        int[][] edges = {{1, 2}, {2, 0}, {0, 3}, {4, 5}, {2, 5}, {5, 0}};

        // Populate the adjacency list with edges
        for (int[] e : edges) {
            addEdge(adj, e[0], e[1]);
        }

        int source = 1;
        int destination = 0;
        System.out.println("DFS from source: " + source);
        Stack<Integer> stack = new Stack<>();
        Stack<Stack<Integer>> allPath = new Stack<>();
        boolean[] visited = new boolean[V];
        printAllPaths(adj, source, destination, visited, stack, allPath);
        System.out.println(allPath);
    }

    private static void printAllPaths(List<List<Integer>> adj, int source, int destination, boolean[] visited, Stack<Integer> stack, Stack<Stack<Integer>> allPath) {
        stack.push(source);
        visited[source] = true;
        if (source == destination) {
            allPath.push((Stack<Integer>) stack.clone());
        }
        for (Integer v : adj.get(source)) {
            if (!visited[v]) printAllPaths(adj, v, destination, visited, stack, allPath);
        }
        visited[source] = false;
        stack.pop();
    }
}
