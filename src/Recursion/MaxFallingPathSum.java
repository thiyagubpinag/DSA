package Recursion;

public class MaxFallingPathSum {
    static int ans = Integer.MIN_VALUE;

    public static int maxFallingPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] b = new boolean[m][n];
        int sum = 0;
        for (int i = 0; i < m; i++) {
            maxFallingPathSumArg(grid, m, n, 0, i, sum, b);
        }
        return ans;

    }

    private static void maxFallingPathSumArg(int[][] grid, int m, int n, int i, int j, int sum, boolean[][] b) {
        if (j > n) {
            return;
        }
        if (i == m) {
            ans=Math.max(ans,sum);
            return;
        }
        if (isSafeArg(m, n, i, j)) {
            for (int k = 0; k < m; k++) {
                if (k != j) {
                    b[i][j] = true;
                    sum += grid[i][j];
                    maxFallingPathSumArg(grid, m, n, i + 1, k, sum, b);
                    sum -= grid[i][j];
                    b[i][j] = false;
                }
            }

        }


    }

    private static boolean isSafeArg(int m, int n, int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

    public static void main(String[] args) {
        int[][] grid={{1,2,3}, {4,5,6}, {7,8,9}};
        int res=maxFallingPathSum(grid);
        System.out.println(res);
    }
}
