package dp;

public class Maze {
    static int count = 0;

    public static void main(String[] args) {
        
        int[][] a = new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 0, 1}};
        boolean[][] b = new boolean[3][3];
        genratePath(a, 0, 0, 3, 3, b);
        System.out.println(count);

    }

    private static void genratePath(int[][] a, int i, int j, int m, int n, boolean[][] b) {
        if (i < 0 || i >= m || j < 0 || j >= m) {
            return;
        }
        if (a[i][j] == 0 || b[i][j]) {
            return;
        }

        if (i == m - 1 && j == n - 1) {
            count++;
        }

        b[i][j] = true;

        genratePath(a, i + 1, j, m, n, b);

        genratePath(a, i - 1, j, m, n, b);

        genratePath(a, i, j + 1, m, n, b);

        genratePath(a, i, j - 1, m, n, b);

        b[i][j] = false;


    }
}
