package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MakeConnected {
    static int step = 0;
    static int count = 0;

    public static int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        List<List<Integer>> adjList = new ArrayList();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList());
        }
        for (int i = 0; i < connections.length; i++) {
            int u = connections[i][0];
            int v = connections[i][1];
            adjList.get(u).add(v);
        }
        int[] disc = new int[n];
        int[] low = new int[n];
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack();
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        for (int i = 0; i < n; i++) {
            if (disc[i] == -1) dfs(i, disc, low, stack, adjList, visited);
        }
        for (int i = 0; i < n; i++) {
            if (disc[i] == i) {
                count++;
            }
        }
        return count;
    }

    public static void dfs(int u, int[] disc, int[] low, Stack<Integer> stack, List<List<Integer>> adjList, boolean[] visited) {
        disc[u] = low[u] = step;
        step += 1;
        stack.push(u);
        visited[u] = true;
        for (Integer v : adjList.get(u)) {
            if (disc[v] == -1) {
                dfs(v, disc, low, stack, adjList, visited);
                low[u] = Math.min(low[u], low[v]);
            } else if (visited[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
        if (low[u] == disc[u]) {
            System.out.println("SCC is :");
            while (stack.peek() != u) {
                System.out.print(stack.peek() + " ");
                visited[stack.pop()] = false;
            }
            System.out.print(stack.peek() + "\n");
            visited[stack.pop()] = false;
        }

    }

    public static void main(String[] args) {
        int[][] connnections = {{0, 1}, {0, 2}, {1, 2}};
        int n = 4;
        System.out.println(makeConnected(n, connnections));
    }
}
