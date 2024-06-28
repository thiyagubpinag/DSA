package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Island {
    static int vertices;
    static List<LinkedList<Integer>> adjacencyList = new ArrayList<>();


    public static int findCircleNum(List<List<Integer>> c) {
        //Write your code here
        vertices = c.size();
        for (int i = 0; i < vertices; i++) {
            LinkedList<Integer> list = new LinkedList();
            adjacencyList.add(list);
        }
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < c.get(i).size(); j++) {
                if (i != j && c.get(i).get(j) == 1) {
                    adjacencyList.get(i).add(j);
                }
            }
        }

        boolean[] visited = new boolean[vertices];
        int count = 0;
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                visited[i] = true;
                callDFS(i, visited);
                count++;
            }
        }


        return count;


    }

    private static void callDFS(int i, boolean[] visited) {
        for (Integer key : adjacencyList.get(i)) {
            if (!visited[key]) {
                visited[key] = true;
                callDFS(key, visited);
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        List<List<Integer>> c = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < arr[i].length; j++) {
                temp.add(arr[i][j]);
            }
            c.add(temp);
        }
        int res = findCircleNum(c);
        System.out.println(res);
    }
}
