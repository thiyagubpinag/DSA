package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class TarjAlgo {
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
        Stack<Integer> stack = new Stack();
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        for (int i = 0; i < V; i++) {
            if (disc[i] == -1) {
                dfs(i, disc, low, stack);
            }
        }
    }

    private static void dfs(int u, int[] disc, int[] low, Stack<Integer> stack) {
        disc[u] = low[u] = time;
        time += 1;
        stack.push(u);

        for (Integer v : graph[u]) {
            if (disc[v] == -1) {
                dfs(v, disc, low, stack);
                low[u] = Math.min(low[u], low[v]);
            } else if (presentInStack(v, stack)) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }

        if (disc[u] == low[u]) {
            System.out.println("Connected Components");
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && low[u] != stack.peek()) {
                    System.out.println(stack.pop());
                }
                System.out.println(stack.pop());
            }
        }

    }

    private static boolean presentInStack(Integer v, Stack<Integer> stack) {
        return stack.contains(v);
    }
}
