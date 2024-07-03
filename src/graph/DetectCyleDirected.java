package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DetectCyleDirected {


    static Integer v;
    static List<List<Integer>> adj = new ArrayList<>();
    static boolean desReachedFlag = false;


    public static void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    public static boolean isCycle(Integer src, Integer des) {
        boolean[] visited = new boolean[v];
        boolean[] recStack = new boolean[v];

        return !isCycleUtil(visited, recStack, src, des) && desReachedFlag;

    }

    private static boolean isCycleUtil(boolean[] visited, boolean[] recStack, Integer src, Integer des) {
        if (recStack[src]) {
            return true;
        }

        if (visited[src]) {
            return false;
        }
        recStack[src] = true;
        visited[src] = true;
        if (Objects.equals(src, des)) {
            desReachedFlag = true;
        }
        List<Integer> neighBour = adj.get(src);
        for (Integer node : neighBour) {
            if (isCycleUtil(visited, recStack, node, des)) {
                return true;
            }
        }
        recStack[src] = false;
        return false;
    }


    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>(List.of(0, 1)));
        input.add(new ArrayList<>(List.of(1, 2)));
        input.add(new ArrayList<>(List.of(2, 0)));
        boolean res = hasValidPath(input, 0, 2);
        System.out.println(res);
    }

    public static boolean hasValidPath(List<List<Integer>> input, int source, int destination) {
        //Write your code here
        v = input.size();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        input.forEach(i -> addEdge(i.get(0), i.get(1)));
        return isCycle(source, destination);
    }
}
