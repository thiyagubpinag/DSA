package dp;

public class KnightMove {
    static int count = 0;

    public static void main(String[] args) {
        int n = 8;
        int m = 8;

        int[][] res = new int[n][m];
        boolean flag = knightMovesExist(n, m, res);

        if (flag) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(res[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Not");
        }
        System.out.println(count);

    }

    private static boolean knightMovesExist(int n, int m, int[][] res) {
        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (knightMove(n, m, i, j, res, vis, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    static int[][] direction = {{-1, 2}, {-1, -2}, {1, 2}, {1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};

    private static boolean knightMove(int n, int m, int i, int j, int[][] res, boolean[][] vis, int index) {
        if (index == n * m) {
            count++;
            return true;
        }
        if (isValidPath(i, j, n, m) && !vis[i][j]) {
            vis[i][j] = true;
            res[i][j] = ++index;
            for (int k = 0; k < 8; k++) {
                int newI = i + direction[k][0];
                int newJ = j + direction[k][1];
                knightMove(n, m, newI, newJ, res, vis, index);
            }
            res[i][j] = index;
            vis[i][j] = false;
        }
        return false;
    }

    private static boolean isValidPath(int i, int j, int n, int m) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }

}
