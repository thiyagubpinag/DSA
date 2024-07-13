package graph;

import java.util.*;

public class ShortestPathEdges {

    public static int shortestPath(int N, int[][] edges, int S, int D) {

        List<List<Integer>> adjList = new ArrayList();
        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
        }
        int[] distance = new int[N];
        boolean[] visited = new boolean[N];

        distance[S] = 0; // Distance of source to itself is 0
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(S);
        visited[S] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // If destination is reached, return the distance
            if (current == D) {
                return distance[current];
            }

            // Explore adjacent nodes
            for (int neighbor : adjList.get(current)) {
                if (!visited[neighbor]) {
                    distance[neighbor] = distance[current] + 1; // Distance to neighbor is 1 more than current
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        // No path found
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arrStr1 = sc.nextLine().split(" ");
        int n = Integer.parseInt(arrStr1[0]);
        int m = Integer.parseInt(arrStr1[1]);
        int[][] edges = new int[m][2];
        for (int i = 0; i < m; i++) {
            String[] arrStr2 = sc.nextLine().split(" ");
            edges[i][0] = Integer.parseInt(arrStr2[0]);
            edges[i][1] = Integer.parseInt(arrStr2[1]);
        }
        String[] arrStr3 = sc.nextLine().split(" ");
        int start = Integer.parseInt(arrStr3[0]);
        int end = Integer.parseInt(arrStr3[1]);
        int res = shortestPath(n, edges, start, end);
        System.out.println(res);
    }
}
