package graph;

import java.util.*;

public class SpanningTree {


    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.

        List<int[]> inputList = new ArrayList<>();
        for (int i = 0; i < adj.size(); i++) {
            List<int[]> temp = adj.get(i);
            for (int j = 0; j < temp.size(); j++) {
                int[] ou = temp.get(j);
                int[] in = new int[3];
                in[0] = i;
                in[1] = ou[0];
                in[2] = ou[1];
                inputList.add(in);
            }
        }

        inputList.sort(Comparator.comparingInt(i -> i[2]));
        int index = 0;
        int[] parent = new int[V];
        Arrays.fill(parent, -1);
        int[] rank = new int[V];
        int sum = 0;
        for (int i = 0; i < E; i++) {
            if (index < V - 1) {
                int[] in = inputList.get(i);
                int u = in[0];
                int v = in[1];
                int w = in[2];
                int uParent = findParent(u, parent);
                int vParent = findParent(v, parent);
                if (uParent != vParent) {
                    index++;
                    sum += w;
                    formCycle(uParent, vParent, parent, rank);
                }
            }
        }

        return sum;
    }

    private static void formCycle(int uParent, int vParent, int[] parent, int[] rank) {
        int uRank = rank[uParent];
        int vRank = rank[vParent];
        if (uRank > vRank) {
            parent[vParent] = uParent;
        } else if (uRank < vRank) {
            parent[uParent] = vParent;
        } else {
            parent[vParent] = uParent;
            rank[uParent]++;
        }
    }

    private static int findParent(int u, int[] parent) {
        int i = parent[u];
        if (i == -1) {
            return u;
        }
        return parent[u] = findParent(i, parent);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        int V = Integer.parseInt(arr[0]);
        int E = Integer.parseInt(arr[1]);
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            String[] input = sc.nextLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);
            adjList.get(u).add(new int[]{v, w});
        }

        //System.out.println(adjList);

        int sum=spanningTree(V, E, adjList);
        System.out.println(sum);
    }
}
