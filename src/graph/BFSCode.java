package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFSCode {

    int vertices;
    LinkedList<Integer>[] adjList;

    @SuppressWarnings("unchecked")
    BFSCode(int vertices) {
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; ++i)
            adjList[i] = new LinkedList<>();
    }

    // Function to add an edge to the graph
    void addEdge(int u, int v) {
        adjList[u].add(v);
    }

    void bfs(int startNode) {
        // Create a queue for BFS
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[vertices];
        int[] level = new int[vertices];
        int[] parent = new int[vertices];
        Arrays.fill(level, -1);
        Arrays.fill(parent, -1);

        // Mark the current node as visited and enqueue it
        visited[startNode] = true;
        queue.add(startNode);
        int step = 1;
        level[startNode] = step - 1;

        while (!queue.isEmpty()) {
            Integer top = queue.peek();
            queue.poll();
            for (Integer adj : adjList[top]) {
                if (!visited[adj]) {
                    level[adj] = step;
                    parent[adj] = top;
                    visited[adj] = true;
                    queue.add(adj);
                }
            }
            step++;
        }
        System.out.println("Done");
    }

    public static void main(String[] args) {
        // Number of vertices in the graph
        int vertices = 5;

        // Create a graph
        BFSCode graph = new BFSCode(vertices);

        // Add edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);

        // Perform BFS traversal starting from vertex 0
        System.out.print("Breadth First Traversal starting from vertex 0: ");
        graph.bfs(0);
    }
}
