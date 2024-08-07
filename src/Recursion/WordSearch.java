package Recursion;

public class WordSearch {
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int rowLen;
    static int colLen;

    public static boolean valid(int row, int col) {
        return row >= 0 && row < rowLen && col >= 0 && col < colLen;
    }

    public static boolean getPath(int row, int col, int count, String word, boolean[][] visited, char[][] board) {
        if (count == word.length()) {
            return true;
        }
        for (int i = 0; i < 4; i++) {
            int r = row + dir[i][0];
            int c = col + dir[i][1];
            if (valid(r, c) && !visited[r][c] && board[r][c] == word.charAt(count)) {
                visited[r][c] = true;
                boolean flag = getPath(r, c, count + 1, word, visited, board);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean exist(char[][] board, String word) {
        rowLen = board.length;
        colLen = board[0].length;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (word.charAt(0) == board[i][j]) {
                    boolean[][] visited = new boolean[rowLen][colLen];
                    visited[i][j] = true;
                    if (getPath(i, j, 1, word, visited, board)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String inp = "ABCCED";
        boolean res = exist(board, inp);
        System.out.println(res);
    }
}
