package graph;

import java.util.*;

public class ArticulationPoints {
    static final int V = 6;

    static class Graph {
        Map<Integer, List<Integer>> adj;

        Graph() {
            adj = new HashMap<>();
        }

        void addEdge(int u, int v) {
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
    }

    static int time = 0;

    static void DFS(int u, int[] disc, int[] low, int[] parent, boolean[] articulationPoint, Graph g) {

        disc[u] = low[u] = time++;
        int children = 0;
        for (int v : g.adj.getOrDefault(u, Collections.emptyList())) {
            if (disc[v] == -1) {
                children++;
                parent[v] = u;
                DFS(v, disc, low, parent, articulationPoint, g);
                low[u] = Math.min(low[u], low[v]);
                if (parent[u] == -1 && children > 1) articulationPoint[u] = true;
                if (parent[u] != -1 && low[v] >= disc[u]) articulationPoint[u] = true;
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    static void findAPs(Graph g) {
        int[] disc = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];
        boolean[] articulationPoint = new boolean[V];
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        Arrays.fill(parent, -1);
        Arrays.fill(articulationPoint, false);

        for (int i = 0; i < V; i++)
            if (disc[i] == -1) DFS(i, disc, low, parent, articulationPoint, g);

        System.out.print("Articulation Points are: ");
        for (int i = 0; i < V; i++)
            if (articulationPoint[i]) System.out.print(i + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);

        findAPs(g);
    }
}