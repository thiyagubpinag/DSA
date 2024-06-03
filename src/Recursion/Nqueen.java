package Recursion;

public class Nqueen {
    public static void main(String[] args) {
        int[][] chessBoard = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        int n = chessBoard.length;
        System.out.println(findNqueen(chessBoard, 0, n));

    }

    static boolean isSafe(int board[][], int row, int col, int n) {
        int i, j;

        // Check this row on left side
        for (i = 0; i < col; i++)
            if (board[row][i] == 1) return false;

        // Check upper diagonal on left side
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1) return false;

        // Check lower diagonal on left side
        for (i = row, j = col; j >= 0 && i < n; i++, j--)
            if (board[i][j] == 1) return false;

        return true;
    }

    private static boolean findNqueen(int[][] chessBoard, int col, int n) {

        if (col >= n) {
            return true;
        }
        boolean flag=false;
        for (int i = 0; i < n; i++) {
            if (isSafe(chessBoard, i, col, n)) {
                chessBoard[i][col] = 1;
                if (findNqueen(chessBoard, col + 1, n)) {
                    flag=true;
                }
                chessBoard[i][col] = 0;
            }
        }
        return flag;

    }


}

