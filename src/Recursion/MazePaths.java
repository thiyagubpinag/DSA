package Recursion;

import java.util.ArrayList;

public class MazePaths {
    public static void main(String[] args) {
        int[][] maze = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}};
        boolean[][] visited = new boolean[maze.length][maze.length];

        int n = maze.length;
        // List to store all the valid paths
        ArrayList<String> result = new ArrayList<>();
        // Store current path
        StringBuilder currentPath = new StringBuilder();

        if (maze[0][0] != 0 && maze[n - 1][n - 1] != 0) {
            // Function call to get all valid paths
            findPath(0, 0, maze, n, result, currentPath, visited);
        }

        if (result.size() == 0) System.out.println(-1);
        else for (String path : result)
            System.out.print(path + " ");
        System.out.println();
    }

    static String direction = "DLRU";
    // Arrays to represent change in rows and columns
    static int[] dr = {1, 0, 0, -1};
    static int[] dc = {0, -1, 1, 0};

    private static void findPath(int row, int col, int[][] maze, int n, ArrayList<String> result, StringBuilder currentPath, boolean[][] visited) {
        if (row == n-1 && col == n-1) {
            result.add(currentPath.toString());
            return;
        }
        if (validData(row, col, n) && maze[row][col] == 1 && !visited[row][col]) {
            visited[row][col] = true;
            for (int i = 0; i < 4; i++) {
                int dRow = dr[i] + row;
                int dCol = dc[i] + col;
                if (validData(dRow, dCol, n) && maze[dRow][dCol] == 1 && !visited[dRow][dCol]) {
                    currentPath.append(direction.charAt(i));
                    findPath(dRow, dCol, maze, n, result, currentPath, visited);
                    currentPath.deleteCharAt(currentPath.length() - 1);
                }
            }
            visited[row][col] = false;
        }
    }

    private static boolean validData(int row, int col, int n) {
        if (row < 0 || row >= n || col < 0 || col >= n) {
            return false;
        }
        return true;
    }
}
