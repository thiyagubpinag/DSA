package com.graph.revision;

import java.util.ArrayList;
import java.util.*;

public class DijiktrasAlgo {
    private int V;
    private List<List<iPair>> adj;

    DijiktrasAlgo(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    void addEdge(int u, int v, int w) {
        adj.get(u).add(new iPair(v, w));
        adj.get(v).add(new iPair(u, w));
    }

    void shortestPath(int src) {
        PriorityQueue<iPair> pq = new PriorityQueue<>(V, Comparator.comparingInt(o -> o.first));
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.add(new iPair(0, src));
        dist[src] = 0;

        while (!pq.isEmpty()) {
            iPair iPair = pq.poll();
            for (DijiktrasAlgo.iPair pair : adj.get(iPair.second)) {
                int u = iPair.second;
                int v = pair.first;
                if (dist[v] > dist[u] + pair.second) {
                    dist[v] = dist[u] + pair.second;
                    pq.add(new iPair(dist[v], v));
                }

            }
        }


        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t\t" + dist[i]);
        }
    }

    static class iPair {
        int first, second;

        iPair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        int V = 9;
        DijiktrasAlgo g = new DijiktrasAlgo(V);

        g.addEdge(0, 1, 4);
        g.addEdge(0, 7, 8);
        g.addEdge(1, 2, 8);
        g.addEdge(1, 7, 11);
        g.addEdge(2, 3, 7);
        g.addEdge(2, 8, 2);
        g.addEdge(2, 5, 4);
        g.addEdge(3, 4, 9);
        g.addEdge(3, 5, 14);
        g.addEdge(4, 5, 10);
        g.addEdge(5, 6, 2);
        g.addEdge(6, 7, 1);
        g.addEdge(6, 8, 6);
        g.addEdge(7, 8, 7);

        g.shortestPath(0);
    }
}
