package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BiParphite {
    static boolean[] visited;
    static int[] marked;

    public static boolean bipartite(int V, ArrayList<ArrayList<Integer>> adj, int u, int var) {
        visited[u] = true;
        marked[u] = var;
        for (Integer v : adj.get(u)) {
            System.out.println(visited[v] + "," + marked[v] + "," + v + "," + u + "," + marked[u] + "," + visited[u]);
            if (!visited[v]) {
                if (!bipartite(V, adj, v, 1 - var)) {
                    return false;
                }
            } else if (visited[v] && marked[v] == marked[u]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        visited = new boolean[V];
        marked = new int[V];
        Arrays.fill(marked, -1);
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (!bipartite(V, adj, i, 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList();
        int[][] arr = {{2}, {2, 3}, {0, 1, 3}, {1, 2}};
        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < arr[i].length; j++) {
                temp.add(arr[i][j]);
            }
            adjList.add(temp);
        }
        boolean res = isBipartite(4, adjList);
        System.out.println(res);
    }
}
