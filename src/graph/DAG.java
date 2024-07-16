package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DAG {
    public static boolean isDAG(int N, List<int[]> edges) {
        List<List<Integer>> adjList = new ArrayList();
        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList());
        }

        for (int i = 0; i < edges.size(); i++) {
            adjList.get(edges.get(i)[0]).add(edges.get(i)[1]);
        }
        boolean[] preStack = new boolean[N];
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (dfsUtilsDAG(i, adjList, preStack, visited)) {
                return true;
            }
        }
        return true;
    }

    private static boolean dfsUtilsDAG(int i, List<List<Integer>> adjList, boolean[] preStack, boolean[] visited) {

        if (preStack[i]) {
            return true;
        }
        if (visited[i]) {
            return false;
        }

        visited[i] = true;
        preStack[i] = true;
        for (Integer adj : adjList.get(i)) {
            if(dfsUtilsDAG(adj, adjList, preStack, visited)){
                return true;
            }
        }

        preStack[i] = false;
        return false;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arrStr1 = sc.nextLine().split(" ");
        int n = Integer.parseInt(arrStr1[0]);
        int m = Integer.parseInt(arrStr1[1]);
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int[] arr = new int[2];
            String[] arrStr = sc.nextLine().split(" ");
            arr[0] = Integer.parseInt(arrStr[0]);
            arr[1] = Integer.parseInt(arrStr[1]);
            edges.add(arr);
        }
        boolean res = isDAG(n, edges);
        System.out.println(res);
    }
}
