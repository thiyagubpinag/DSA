import java.util.*;

class KahnAlgo {

    class Graph {
        int n;
        List<List<Integer>> adjList = new ArrayList<>();
        int[] inDegree;

        Graph(int n) {
            this.n = n;
            for (int i = 0; i < n; i++)
                adjList.add(new ArrayList<>());
            inDegree = new int[n];
        }

        public void addEdge(int u, int v) {
            adjList.get(u).add(v);
            inDegree[v]++;
        }
    }

    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        Graph graph = new Graph(n);
        for (int[] relation : relations) {
            graph.addEdge(relation[0] - 1, relation[1] - 1);
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (graph.inDegree[i] == 0)
                queue.add(i);
        }

        int semesters = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            semesters += (size / k) + 1;
            if (size % k == 0) {
                semesters--;
            }
            for (int i = 0; i < size; i++) {
                int u = queue.poll();
                for (int v : graph.adjList.get(u)) {
                    graph.inDegree[v]--;
                    if (graph.inDegree[v] == 0) {
                        queue.add(v);
                    }
                }
            }
        }

        return semesters;

    }

    public static void main(String[] args) {
        int n = 5;
        int[][] relations = { { 3, 1 } };
        int k = 4;
        KahnAlgo kahnAlgo = new KahnAlgo();
        int res = kahnAlgo.minNumberOfSemesters(n, relations, k);
        System.out.println(res);
    }
}