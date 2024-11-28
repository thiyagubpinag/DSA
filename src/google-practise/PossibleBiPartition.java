import java.util.*;

public class PossibleBiPartition {

    public static void main(String[] args) {
        int n = 4;
        int[][] dislikes = { { 1, 2 }, { 1, 3 }, { 2, 3 } };

        PossibleBiPartition possibleBiPartition = new PossibleBiPartition();
        boolean res = possibleBiPartition.possibleBipartition(n, dislikes);
        System.out.println(res);
    }

    private boolean possibleBipartition(int n, int[][] dislikes) {
        boolean[] visited = new boolean[n + 1];
        boolean[] color = new boolean[n + 1];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < dislikes.length; i++) {
            int u = dislikes[i][0];
            int v = dislikes[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        color[0] = true;
        visited[0] = true;
        for (int i = 0; i < n; i++) {
            if (!dfs(color, visited, i, graph)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(boolean[] color, boolean[] visited, int i, List<List<Integer>> graph) {
        if (visited[i]) {
            return true;
        }

        visited[i] = true;
        for (int neighbor : graph.get(i)) {
            if (!visited[neighbor]) {
                color[neighbor] = !color[i];
                if (!dfs(color, visited, neighbor, graph)) {
                    return false;
                }
            } else if (color[neighbor] == color[i]) {
                return false;
            }
        }

        return true;

    }
}