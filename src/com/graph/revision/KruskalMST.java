package com.graph.revision;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KruskalMST {
    static class Edge {
        int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    // Defines subset element structure
    static class Subset {
        int parent, rank;

        public Subset(int parent, int rank) {
            this.parent = parent;
            this.rank = rank;
        }
    }

    // Starting point of program execution
    public static void main(String[] args) {
        int V = 4;
        List<Edge> graphEdges = new ArrayList<Edge>(List.of(new Edge(0, 1, 10), new Edge(0, 2, 6), new Edge(0, 3, 5), new Edge(1, 3, 15), new Edge(2, 3, 4)));

        // Sort the edges in non-decreasing order
        // (increasing with repetition allowed)
        graphEdges.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });

        kruskals(V, graphEdges);
    }

    private static void kruskals(int v, List<Edge> graphEdges) {
        List<Subset> subsetList = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            subsetList.add(new Subset(i, 0));
        }

        graphEdges.forEach(edge -> {
            int start = edge.src;
            int end = edge.dest;

            unionAll(start, end, graphEdges, subsetList);

        });

    }

    private static void unionAll(int start, int end, List<Edge> graphEdges, List<Subset> subsetList) {
        int u = findParent(subsetList, start);
        int v = findParent(subsetList, end);

        if (u == v) {
            return;
        }

        int uRank = subsetList.get(u).rank;
        int vRank = subsetList.get(v).rank;

        if (uRank > vRank) {
            subsetList.get(v).parent = u;
        } else if (uRank < vRank) {
            subsetList.get(u).parent = v;
        } else {
            subsetList.get(v).parent = u;
            subsetList.get(u).rank++;
        }
    }

    private static int findParent(List<Subset> subsetList, int start) {
        Subset subset = subsetList.get(start);
        if (subset.parent == start) {
            return start;
        }
        return subset.parent = findParent(subsetList, subset.parent);
    }
}
