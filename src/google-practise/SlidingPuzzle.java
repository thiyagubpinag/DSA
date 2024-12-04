public class SlidingPuzzle {

    public int dfs(int[][] board, int row, int col, boolean[][] visited) {
        if (!isValid(row, col, board, visited)) {
            return Integer.MAX_VALUE;
        }
        if (isSolved(board)) {
            return -1;
        }

        int min = Integer.MAX_VALUE;
        visited[row][col] = true;

        int[][] dir = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

        for (int[] d : dir) {
            int newRow = row + d[0];
            int newCol = col + d[1];

            if (isValid(newRow, newCol, board, visited)) {
                swap(board, row, col, newRow, newCol);
                int temp = dfs(board, newRow, newCol, visited);
                if (temp != Integer.MAX_VALUE)
                    min = Math.min(min, 1 + temp);
                swap(board, row, col, newRow, newCol);
            }
        }

        visited[row][col] = false;
        return min;
    }

    private void swap(int[][] board, int row, int col, int newRow, int newCol) {
        int temp = board[row][col];
        board[row][col] = board[newRow][newCol];
        board[newRow][newCol] = temp;
    }

    private boolean isValid(int newRow, int newCol, int[][] board, boolean[][] visited) {
        return newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length
                && !visited[newRow][newCol];
    }

    private boolean isSolved(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != 0 && board[i][j] != 1 + i * board[0].length + j) {
                    return false;
                }
            }
        }
        return true;
    }

    public int slidingPuzzle(int[][] board) {
        int min = Integer.MAX_VALUE;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    int temp = dfs(board, i, j, visited);
                    if (temp != Integer.MAX_VALUE)
                        min = Math.min(min, 1 + temp);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        int[][] board = { { 1, 2, 3 }, { 5, 4, 0 } };
        SlidingPuzzle slidingPuzzle = new SlidingPuzzle();
        int res = slidingPuzzle.slidingPuzzle(board);
        System.out.println(res);
    }
}
