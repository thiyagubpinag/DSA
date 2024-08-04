package graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UnionFind {
    static int[] parent;
    static int[] rank;

    public static int makeConnected(int n, int[][] connections) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        Arrays.fill(rank, 0);
        for (int i = 0; i < connections.length; i++) {
            int u = connections[i][0];
            int v = connections[i][1];
            int uParent = findParent(u);
            int vParent = findParent(v);
            if (uParent != vParent) {
                makeUnion(uParent, vParent);
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < parent.length; i++) {
            set.add(parent[i]);
        }
        return set.size() - 1;
    }

    private static void makeUnion(int u, int v) {
        int uRank = rank[u];
        int vRank = rank[v];
        if (uRank < vRank) {
            parent[u] = v;
        } else if (vRank < uRank) {
            parent[v] = u;
        } else {
            parent[v] = u;
            rank[v]++;
        }
    }

    private static int findParent(int u) {
        if (parent[u] == u) {
            return u;
        }
        parent[u] = findParent(parent[u]);
        return parent[u];
    }

    public static void main(String[] args) {
        int[][] arr = {{0, 1}, {0, 2}, {1, 2}};
        int n = 4;
        int res = makeConnected(n, arr);
        System.out.println(res);
    }
}
