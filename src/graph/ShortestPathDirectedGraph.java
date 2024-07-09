package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShortestPathDirectedGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arrStr1 = sc.nextLine().split(" ");
        int n = Integer.parseInt(arrStr1[0]);
        int m = Integer.parseInt(arrStr1[0]);
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] arrStr = sc.nextLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(arrStr[j]);
            }
        }

        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            min = Integer.MAX_VALUE;
            dfsCall(i, arr, n, output);
        }
        System.out.println(output);
    }

    static int min = Integer.MAX_VALUE;

    private static void dfsCall(int index, int[][] arr, int n, List<Integer> output) {
        boolean[] visited = new boolean[n];
        for (int i = 0; i < arr[index].length; i++) {
            if (arr[index][i] == 1) {
                dfsUtilsMethod(index, i, arr, visited, 0, output);
                visited[i] = true;
            }
        }
        if (min == Integer.MAX_VALUE) {
            output.add(-1);
            return;
        }
        output.add(min);

    }

    private static void dfsUtilsMethod(int index, int i, int[][] arr, boolean[] visited, int count, List<Integer> output) {
        if (index == i) {
            min = Math.min(count + 1, min);
        }else {
            if (!visited[i]) {
                visited[i] = true;
                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j] == 1 && !visited[j]) {
                        dfsUtilsMethod(index, j, arr, visited, count + 1, output);
                    }
                }
            }
        }
        visited[i] = false;
    }


}
