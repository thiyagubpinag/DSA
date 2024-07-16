package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TarjansAlgo {
    static final int V = 7;
    static int time = 0;
    static List<Integer> graph[];

    public static void main(String[] args) {
        graph = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new LinkedList<Integer>();
        }
        graph[0].add(1);
        graph[1].add(2);
        graph[1].add(3);
        graph[3].add(4);
        graph[4].add(0);
        graph[4].add(5);
        graph[4].add(6);
        graph[5].add(6);
        graph[6].add(5);

        findSCCs_Trajan();
    }

    private static void findSCCs_Trajan() {
        int[] disc = new int[V];
        int[] low = new int[V];
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        for (int i = 0; i < V; i++) {
            if (disc[i] == -1) DFS(i, disc, low, visited, stack);
        }

    }

    private static void DFS(int i, int[] disc, int[] low, boolean[] visited, Stack<Integer> stack) {

        disc[i]=low[i]=time;
        time+= 1;
        stack.push(i);
        visited[i] = true;

        for (Integer v : graph[i]) {
            if (disc[v] == -1) {
                DFS(v, disc, low, visited, stack);
                low[i] = Math.min(low[i], low[v]);
            } else if (visited[i]) {
                low[i] = Math.min(low[i], disc[v]);
            }
        }
        if (low[i] == disc[i]) {
            System.out.println("SCC is :");
            while (stack.peek() != i) {
                System.out.print(stack.peek() + " ");
                visited[stack.pop()] = false;
            }
            System.out.print(stack.peek() + "\n");
            visited[stack.pop()] = false;
        }


    }
}
