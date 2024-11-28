
public class MinFallingPath {

    public int getMinFallingPath(int[][] matrix, int row, int col) {

        int n = matrix.length;
        if (row < 0 || row >= n || col < 0 || col >= n) {
            return Integer.MAX_VALUE;
        }
        if (row == matrix.length - 1) {
            return matrix[row][col];
        }
        int min = Integer.MAX_VALUE;
        int ld = getMinFallingPath(matrix, row + 1, col - 1);
        if (ld != Integer.MAX_VALUE) {
            min = Math.min(min, matrix[row][col] + ld);
        }
        int d = getMinFallingPath(matrix, row + 1, col);
        if (d != Integer.MAX_VALUE) {
            min = Math.min(min, matrix[row][col] + d);
        }
        int rd = getMinFallingPath(matrix, row + 1, col + 1);
        if (rd != Integer.MAX_VALUE) {
            min = Math.min(min, matrix[row][col] + rd);
        }

        return min;

    }

    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            min = Math.min(min, getMinFallingPath(matrix, 0, i));
        }

        return min;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };
        MinFallingPath minFallingPath = new MinFallingPath();
        int res = minFallingPath.minFallingPathSum(matrix);
        System.out.println(res);

    }
}