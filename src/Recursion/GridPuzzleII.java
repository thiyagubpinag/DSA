package Recursion;

public class GridPuzzleII {
    public static int gridPuzzleII(int n, int m, int[][] obstacleGrid) {
        gridpuzzle_I(0, 0, m, n, obstacleGrid);
        return count;
    }

    static int count = 0;

    public static void gridpuzzle_I(int x1, int x2, int y1, int y2, int[][] obstacleGrid) {

        if (x1 == y1 - 1 && x2 == y2 - 1) {
            count++;
            return;
        }

        if (safe(x1, x2, y1, y2) && obstacleGrid[x1][x2] == 0) {

            gridpuzzle_I(x1 + 1, x2, y1, y2, obstacleGrid);
            gridpuzzle_I(x1, x2 + 1, y1, y2, obstacleGrid);

        }

    }

    public static boolean safe(int x1, int x2, int y1, int y2) {
        return x1 < y1 && x2 < y2;
    }
}
