package com.graph.revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ArtifactPoints {

    int vertex;
    List<List<Integer>> adj = new ArrayList<>();

    private void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    ArtifactPoints(int v) {
        this.vertex = v;
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public static void main(String[] args) {
        // Create a graph given in the above diagram
        ArtifactPoints g1 = new ArtifactPoints(5);

        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        System.out.println("SSC in first graph ");
        g1.SCC();
    }


    private void SCC() {
        int[] disc = new int[vertex];
        int[] low = new int[vertex];
        int[] parent = new int[vertex];

        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);

        for (int i = 0; i < vertex; i++) parent[i] = i;

        for (int i = 0; i < vertex; i++) {
            dfs(i, disc, low, parent);
        }

    }

    int step = 0;

    private void dfs(int u, int[] disc, int[] low, int[] parent) {
        disc[u] = low[u] = step;
        step++;
        AtomicInteger children = new AtomicInteger();

        adj.get(u).forEach(v -> {
            if (disc[v] == -1) {
                parent[v] = u;
                children.getAndIncrement();
                dfs(v, disc, low, parent);
                low[u] = Math.min(low[u], low[v]);


                if (parent[u] == u && children.get() > 1) {
                    System.out.println(u);
                } else if (parent[u] != u && low[v] > disc[u]) {
                    System.out.println(u);
                }

            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }

        });
    }

}
