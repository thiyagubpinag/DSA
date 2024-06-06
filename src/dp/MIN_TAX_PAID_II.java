package dp;

public class MIN_TAX_PAID_II {
    static int ans = Integer.MAX_VALUE;

    public static int solve(int[][] ar, int m, int n) {
        boolean[][] b = new boolean[m][n];
        moveGrid(ar, 0, 0, b, 0);
        return ans;
    }

    static void moveGrid(int[][] ar, int m, int n, boolean[][] b, int sum) {
        if (m == ar.length - 1 && n == ar[0].length - 1) {
            sum += ar[m][n];
            ans = Math.min(ans, sum);
        }
        if (isSafe(ar, m, n) && !b[m][n]) {
            b[m][n] = true;
            sum += ar[m][n];
            moveGrid(ar, m + 1, n + 1, b, sum);
            moveGrid(ar, m - 1, n, b, sum);
            moveGrid(ar, m, n - 1, b, sum);
            moveGrid(ar, m + 1, n, b, sum);
            moveGrid(ar, m, n + 1, b, sum);
            sum -= ar[m][n];
            b[m][n] = false;
        }

    }

    static boolean isSafe(int[][] arr, int m, int n) {
        return m >= 0 && m < arr.length && n >= 0 && n < arr[0].length;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]
                {{2, 1, 1},
                  {6, 5, 1},
                  {7, 8, 9}};
        int res = solve(arr, arr.length, arr[0].length);
        System.out.println(res);
    }
}
