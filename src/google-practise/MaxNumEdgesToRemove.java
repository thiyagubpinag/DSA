import java.util.Arrays;
import java.util.Comparator;

public class MaxNumEdgesToRemove {

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int count = 0;
        int[] parent = new int[n];
        int[] rank = new int[n];

        // 1- alice
        // 2- bob
        Arrays.sort(edges, Comparator.comparingInt(i -> i[0]));
        for (int i = 1; i <= 2; i++) {
            Arrays.fill(parent, -1);
            Arrays.fill(rank, -1);
            for (int j = 0; j < edges.length; j++) {
                int type = edges[j][0];
                int u = edges[j][1] - 1;
                int v = edges[j][2] - 1;
                if (!(type == i || type == 3)) {
                    continue;
                }
                int uParent = find(u, parent);
                int vParent = find(v, parent);
                if (uParent != vParent) {
                    union(uParent, vParent, rank, parent);
                } else {
                    count++;
                }
            }
            int parentCount = 0;
            for (int k = 0; k < n; k++) {
                if (parent[k] == -1) {
                    parentCount++;
                }
                if (parentCount > 1) {
                    return -1;
                }
            }
        }

        return count;
    }

    private void union(int uParent, int vParent, int[] rank, int[] parent) {

        if (rank[uParent] < rank[vParent]) {
            parent[uParent] = vParent;
        } else if (rank[uParent] > rank[vParent]) {
            parent[vParent] = uParent;
        } else {
            parent[vParent] = uParent;
            rank[uParent]++;
        }
    }

    private int find(int u, int[] parent) {
        if (parent[u] == -1) {
            return u;
        }
        return parent[u] = find(parent[u], parent);
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = { { 3, 1, 2 }, { 3, 2, 3 }, { 1, 1, 4 }, { 2, 1, 4 } };
        MaxNumEdgesToRemove maxNumEdgesToRemove = new MaxNumEdgesToRemove();
        int res = maxNumEdgesToRemove.maxNumEdgesToRemove(n, edges);
        System.out.println(res);

    }
}
