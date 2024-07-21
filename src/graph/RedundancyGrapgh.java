package graph;

import java.util.Arrays;

public class RedundancyGrapgh {
    public static int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];

        Arrays.fill(parent, -1);

        for (int[] edge : edges) {
            if (!unionAdd(parent, edge)) {
                return edge;
            }
        }
        return new int[0];
    }

    static int findParent(int i, int[] parent) {
        int value = parent[i - 1];
        if (value == -1) {
            return i;
        }
        return findParent(value, parent);
    }


    public static boolean unionAdd(int[] parent, int[] edge) {
        int u = edge[0];
        int v = edge[1];

        int uPar = findParent(u, parent);
        int vPar = findParent(v, parent);

        if (uPar == vPar) {
            return false;
        }
        parent[v - 1] = u;
        return true;
    }

    public static void main(String[] args) {
        int[][] edges = {{1, 2}};
        int[] edge = findRedundantConnection(edges);
       //System.out.println(edge[0] + "," + edge[1]);
        System.out.println("Done");
    }
}
