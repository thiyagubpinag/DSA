package dp;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanta {
    static boolean[][] pac;
    static boolean[][] atl;

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        pac = new boolean[n][m];
        atl = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            pac[i][0] = true;
            atl[i][m - 1] = true;
        }

        for (int i = 0; i < m; i++) {
            pac[0][i] = true;
            atl[n - 1][i] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dfsUtilsCheck(i, j, n, m, 'P', heights);
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                dfsUtilsCheck(i, j, n, m, 'A', heights);
            }
        }

        List<List<Integer>> result = new ArrayList();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pac[i][j] && atl[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }

        return result;
    }

    static int[][] direction = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    private static void dfsUtilsCheck(int i, int j, int n, int m, char pacOrAlt, int[][] heights) {
        boolean[][] visited = new boolean[n][m];
        if (dfsUtilsCheckCondition(i, j, n, m, pacOrAlt, heights, visited)) {
            pac[i][j] = true;
        }
    }

    private static boolean dfsUtilsCheckCondition(int i, int j, int n, int m, char pacOrAlt, int[][] heights, boolean[][] visited) {
        if(i<0 || i>=n || j<0 || j>=m){
            return false;
        }
        if (visited[i][j]) {
            return false;
        }
        if (pacOrAlt == 'P') {
            if (i == 0 || j == 0) {
                return true;
            }
            if (heights[i][j] >= heights[i - 1][j]) {
                pac[i][j] = pac[i][j] || pac[i - 1][j];
            }
            if (heights[i][j] >= heights[i][j - 1]) {
                pac[i][j] = pac[i][j] || pac[i][j - 1];
            }
            if (pac[i][j]) {
                return true;
            }
        }
        if (pacOrAlt == 'A') {
            if (i == n - 1 || j == m - 1) {
                return true;
            }
            if (heights[i][j] >= heights[i + 1][j]) {
                atl[i][j] = atl[i][j] || atl[i + 1][j];
            }
            if (heights[i][j] >= heights[i][j + 1]) {
                atl[i][j] = atl[i][j] || atl[i][j + 1];
            }
            if (atl[i][j]) {
                return true;
            }
        }

        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int newI = i + direction[k][0];
            int newj = j + direction[k][1];
            if (dfsUtilsCheckCondition(newI, newj, n, m, pacOrAlt, heights, visited)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] heights= {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        //int[][] heights= {{1,1},{1,1},{1,1}};
        //int[][] heights= {{10,10,10},{10,1,10},{10,10,10}};
        //int[][] heights = {{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
        var result=pacificAtlantic(heights);
        System.out.println(result);
    }
}
