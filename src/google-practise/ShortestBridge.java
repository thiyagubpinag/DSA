import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {

    public void dfs(int[][] grid, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid.length || visited[row][col] ||
                grid[row][col] == 0) {
            return;
        }
        grid[row][col] = 2;
        visited[row][col] = true;
        dfs(grid, row - 1, col, visited);
        dfs(grid, row + 1, col, visited);
        dfs(grid, row, col - 1, visited);
        dfs(grid, row, col + 1, visited);

    }

    public int shortestBridge(int[][] grid) {
        // set the first island
        boolean flag = false;
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, visited);
                    flag = true;
                    break;
                }
            }
            if (flag)
                break;
        }

        // start perform bfs
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], false);
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[] { i, j });
                    visited[i][j] = true;
                }
            }
        }

        int step = 0;
        int[] rows = { -1, 0, 0, 1 };
        int[] cols = { 0, 1, -1, 0 };
        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] src = queue.poll();
                int row = src[0];
                int col = src[1];

                for (int j = 0; j < 4; j++) {
                    int newRow = row + rows[j];
                    int newCol = col + cols[j];
                    if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid.length
                            || visited[newRow][newCol] || grid[newRow][newCol] == 1) {
                        continue;
                    }
                    visited[newRow][newCol] = true;
                    if (grid[newRow][newCol] == 2) {
                        return step;
                    }
                    queue.add(new int[] { newRow, newCol });
                }

            }
            step++;

        }
        return -1;

    }

    public static void main(String[] args) {
        int[][] arr = { { 0, 1, 0 }, { 0, 0, 0 }, { 0, 0, 1 } };
        ShortestBridge shortestBridge = new ShortestBridge();
        int res = shortestBridge.shortestBridge(arr);
        System.out.println(res);
    }
}
