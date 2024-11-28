package graph;

import java.util.*;

public class Kosaru {
    static int step = 0;

    public static void dfs(int[] disc, int[] low, Stack<Integer> visited, int u, ArrayList<ArrayList<Integer>> adj) {

        low[u] = disc[u] = step;
        visited.push(u);
        step++;

        for (Integer v : adj.get(u)) {
            if (disc[v] == -1) {
                dfs(disc, low, visited, v, adj);
                low[u] = Math.min(low[u], low[v]);
            } else if (visited.contains(v)) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }

        if (disc[u] == low[u]) {
            while (!visited.isEmpty() && visited.peek() != u) {
                //System.out.print(visited.pop() + " ");
            }
            //System.out.println(visited.pop());
        }

    }

    public static int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        //code here
        int[] disc = new int[V];
        int[] low = new int[V];
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        Stack<Integer> visited = new Stack();

        dfs(disc, low, visited, 0, adj);


        HashSet<Integer> set = new HashSet();
        for (int i = 0; i < V; i++) {
            set.add(low[i]);
        }

        return set.size();

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        int V = Integer.parseInt(arr[0]);
        int E = Integer.parseInt(arr[1]);
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            String[] input = sc.nextLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            adjList.get(u).add(v);
        }

        //System.out.println(adjList);

        int sum = kosaraju(V, adjList);
        System.out.println(sum);
    }
}
