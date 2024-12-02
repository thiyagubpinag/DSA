import java.util.*;

public class ShortestPathLength {

    int count = 0;
    int[] disc;
    int[] low;
    int[] parent;
    int result = 0;
    Stack<Integer> stack = new Stack<Integer>();

    private void dfs(int u, int[][] graph) {
        count++;
        disc[u] = count;
        low[u] = count;
        stack.push(u);

        for (int v : graph[u]) {
            parent[v] = u;
            if (disc[v] == -1) {
                dfs(v, graph);
                low[u] = Math.min(low[u], low[v]);
            } else if (presentInStack(v)) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }

        if (low[u] == disc[u]) {
            int temp = 0;
            while (stack.peek() != u) {
                temp++;
                stack.pop();
            }

            result += (temp > 0 ? temp : 1);

            stack.pop();
        }

    }

    private boolean presentInStack(int v) {
        return stack.contains(v);
    }

    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        disc = new int[n];
        low = new int[n];
        parent = new int[n];
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        Arrays.fill(parent, -1);
        for (int i = 0; i < n; i++) {
            if (disc[i] == -1) {
                dfs(i, graph);
            }
        }

        return result;

    }

    public static void main(String[] args) {
        int[][] graph = { { 1 }, { 0, 2, 4 }, { 1, 3, 4 }, { 2 }, { 1, 2 } };
        ShortestPathLength shortestPathLength = new ShortestPathLength();
        int res = shortestPathLength.shortestPathLength(graph);
        System.out.println(res);
    }
}
