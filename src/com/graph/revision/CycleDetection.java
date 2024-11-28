package com.graph.revision;

import java.util.ArrayList;
import java.util.List;

public class CycleDetection {
    public static void main(String[] args) {
        int V = 4;
        List<List<Integer>> adj = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges to the graph
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(2).add(3);
        adj.get(3).add(3);

        // Function call
        if (isCyclic(adj, V)) {
            System.out.println("Contains cycle");
        } else {
            System.out.println("No Cycle");
        }
    }

    private static boolean isCyclic(List<List<Integer>> adj, int v) {
        boolean[] visited = new boolean[v];
        boolean[] recStack = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!visited[i] && isCyclicUtil(adj, i, visited, recStack)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isCyclicUtil(List<List<Integer>> adj, int i, boolean[] visited, boolean[] recStack) {
        visited[i] = true;
        recStack[i] = true;
        for (Integer v : adj.get(i)) {
            if (!visited[v] && isCyclicUtil(adj, v, visited, recStack)) {
                return true;
            } else if (recStack[v]) {
                return true;
            }
        }
        recStack[i] = false;
        return false;
    }
}
