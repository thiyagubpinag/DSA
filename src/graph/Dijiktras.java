package graph;

import java.util.*;

public class Dijiktras {
    static class Graph {
        private int V;
        private List<List<iPair>> adj;

        Graph(int V) {
            this.V = V;
            adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
        }

        void addEdge(int u, int v, int w) {
            adj.get(u).add(new iPair(v, w));
            adj.get(v).add(new iPair(u, w));
        }

        void shortestPath(int src, List<Map.Entry<Integer, Integer>> list) {
            PriorityQueue<iPair> pq = new PriorityQueue<>(V, Comparator.comparingInt(o -> o.second));
            int[] dist = new int[V];
            Arrays.fill(dist, Integer.MAX_VALUE);

            pq.add(new iPair(0, src));
            dist[src] = 0;

            while (!pq.isEmpty()) {
                int u = pq.poll().second;

                for (iPair v : adj.get(u)) {
                    if (dist[v.first] > dist[u] + v.second) {
                        dist[v.first] = dist[u] + v.second;
                        pq.add(new iPair(dist[v.first], v.first));
                    }
                }
            }

            System.out.println("Vertex Distance from Source");
            for (int i = 0; i < V; i++) {
                int finalI = i;
                list.add(new Map.Entry<Integer, Integer>() {
                    @Override
                    public Integer getKey() {
                        return finalI;
                    }

                    @Override
                    public Integer getValue() {
                        return dist[finalI];
                    }

                    @Override
                    public Integer setValue(Integer value) {
                        return dist[finalI];
                    }
                });
            }
        }

        static class iPair {
            int first, second;

            iPair(int first, int second) {
                this.first = first;
                this.second = second;
            }
        }
    }

    public static List<Map.Entry<Integer, Integer>> dijkstra(int n, List<int[]> edges, int start) {
        int V = n;
        Graph g = new Graph(V);
        for (int i = 0; i < edges.size(); i++) {
            g.addEdge(edges.get(i)[0], edges.get(i)[1], edges.get(i)[2]);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList();
        g.shortestPath(start, list);
        return list;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arrStr1 = sc.nextLine().split(" ");
        int n = Integer.parseInt(arrStr1[0]);
        int m = Integer.parseInt(arrStr1[1]);
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] arrStr2 = sc.nextLine().split(" ");
            int[] temp = new int[3];
            temp[0] = Integer.parseInt(arrStr2[0]);
            temp[1] = Integer.parseInt(arrStr2[1]);
            temp[2] = Integer.parseInt(arrStr2[2]);
            edges.add(temp);
        }
        String[] arrStr3 = sc.nextLine().split(" ");
        int start = Integer.parseInt(arrStr3[0]);
        dijkstra(n, edges, start);

    }
}
