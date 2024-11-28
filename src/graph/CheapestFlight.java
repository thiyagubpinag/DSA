package graph;

import java.util.*;

public class CheapestFlight {
    class Node {
        int v;
        int w;
        int k;

        Node(int v, int w, int k) {
            this.v = v;
            this.w = w;
            this.k = k;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int depth) {
        List<List<Node>> adjList = new ArrayList();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList());
        }
        for (int i = 0; i < flights.length; i++) {
            int u = flights[i][0];
            int v = flights[i][1];
            int w = flights[i][2];
            adjList.get(u).add(new Node(v, w, 0));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i.w));
        pq.add(new Node(src, 0, 0));
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        while (!pq.isEmpty()) {
            Node temp = pq.remove();
            int srcU = temp.v;
            int srcW = temp.w;
            if (temp.k > depth) {
                continue;
            }
            for (Node adj : adjList.get(srcU)) {
                int v = adj.v;
                int w = adj.w;
                if (dist[v] >= srcW + w) {
                    dist[v] = srcW + w;
                    pq.add(new Node(v, dist[v], temp.k + 1));
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];

    }

    public static void main(String[] args) {
        CheapestFlight cheapestFlight = new CheapestFlight();
        int[][] flights = {{0, 1, 5}, {1, 2, 5}, {0, 3, 2}, {3, 1, 2}, {1, 4, 1}, {4, 2, 1}};
        int price=cheapestFlight.findCheapestPrice(5, flights, 0, 2, 2);
        System.out.println(price);
    }
}
