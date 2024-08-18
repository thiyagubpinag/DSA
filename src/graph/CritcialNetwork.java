package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CritcialNetwork {
    List<List<Integer>> result = new ArrayList();

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] parent = new int[n];
        int[] disc = new int[n];
        int[] low = new int[n];

        Arrays.fill(parent, -1);
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);

        List<List<Integer>> adjList = new ArrayList();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList());
        }

        for (int i = 0; i < connections.size(); i++) {
            for (Integer v : connections.get(i)) {
                adjList.get(i).add(v);
                adjList.get(v).add(i);
            }
        }

        for (int i = 0; i < n; i++) {
            if (disc[i] == -1) {
                dfs(i, parent, disc, low, adjList);
            }
        }

        return result;

    }

    static int time = 0;

    public void dfs(int u, int[] parent, int[] disc, int[] low, List<List<Integer>> adjList) {

        disc[u] = low[u] = time;
        time += 1;
        for (Integer v : adjList.get(u)) {
            if (disc[v] == -1) {
                parent[v] = u;
                dfs(v, parent, disc, low, adjList);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > disc[u]) {
                    result.add(List.of(u, v));
                }
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    public static void main(String[] args) {
        CritcialNetwork critcialNetwork = new CritcialNetwork();
        int[][] arr = {{0, 1}, {1, 2}, {2, 0}, {1, 3}, {3, 4}, {4, 5}, {5, 3}};
        int n = 6;
        List<List<Integer>> adjList = new ArrayList();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList());
        }
        for (int i = 0; i < arr.length; i++) {
            adjList.get(arr[i][0]).add(arr[i][1]);
        }
        critcialNetwork.criticalConnections(n, adjList);

        critcialNetwork.result.forEach(i -> {
            System.out.println(i);
        });
    }
}
