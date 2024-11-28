import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class MaxSumOfWeights {

    class EdgeWeight {
        int v;
        int edge;

        public EdgeWeight(int v, int edge) {
            this.v = v;
            this.edge = edge;
        }

    }

    class Graph {
        int n;
        List<List<EdgeWeight>> adjLists = new ArrayList<>();
        boolean[] visited;

        public Graph(int n) {
            this.n = n;
            for (int i = 0; i <= n; i++) {
                adjLists.add(new ArrayList<>());
            }
            visited = new boolean[n + 1];
        }

        public void addEdge(int u, int v, int edge) {
            adjLists.get(u).add(new EdgeWeight(v, edge));
            adjLists.get(v).add(new EdgeWeight(u, edge));
        }

        long dfsUtils(int u) {
            this.visited[u] = true;
            long sum = 0;
            for (EdgeWeight edge : adjLists.get(u)) {
                if (!visited[edge.v]) {
                    sum += edge.edge;
                    sum += dfsUtils(edge.v);
                }
            }
            return sum;
        }

        long dfs() {
            long maxSum = 0;
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    maxSum += dfsUtils(i);
                }
            }
            return maxSum;
        }

    }

    public long maximizeSumOfWeights(int[][] edges, int k) {
        int n = edges.length;
        Graph graph = new Graph(n);

        for (int[] edge : edges) {
            graph.addEdge(edge[0], edge[1], edge[2]);
        }

        PriorityQueue<EdgeWeight> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.edge));

        int index = 0;
        for (List<EdgeWeight> adjList : graph.adjLists) {
            if (adjList.size() > k) {
                pq.addAll(adjList);
                while (pq.size() != k) {
                    int u = index;
                    EdgeWeight edgeWeight = pq.poll();
                    int v = edgeWeight.v;
                    graph.adjLists.get(u).removeIf(e -> e.v == v);
                    graph.adjLists.get(v).removeIf(e -> e.v == u);
                }
                pq.clear();
            }
            index++;
        }

        return graph.dfs();

    }

    public static void main(String[] args) {
        int[][] edges = { { 0, 1, 25 }, { 0, 2, 10 }, { 1, 3, 29 } };
        int k = 1;

        MaxSumOfWeights maxSumOfWeights = new MaxSumOfWeights();
        long res = maxSumOfWeights.maximizeSumOfWeights(edges, k);
        System.out.println(res);
    }
}
