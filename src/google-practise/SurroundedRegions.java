public class SurroundedRegions {
    public boolean dfsArea(char[][] board, int n, int i, int j, int dir) {
        if (i < 0 || i >= n || j < 0 || j >= n) {
            return false;
        }
        if (board[i][j] == 'X') {
            return true;
        }

        switch (dir) {
            case 0:
                return dfsArea(board, n, i + 1, j, dir);
            case 1:
                return dfsArea(board, n, i - 1, j, dir);
            case 2:
                return dfsArea(board, n, i, j + 1, dir);
            case 3:
                return dfsArea(board, n, i, j - 1, dir);
            default:
                return false;
        }

    }

    public boolean dfs(char[][] board, int n, int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= n) {
            return false;
        }
        if (board[i][j] == 'X') {
            return true;
        }

        return dfsArea(board, n, i + 1, j, 0) && dfsArea(board, n, i - 1, j, 1) &&
                dfsArea(board, n, i, j + 1, 2) && dfsArea(board, n, i, j - 1, 3);
    }

    public void solve(char[][] board) {
        int n = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    if (dfs(board, n, i, j)) {
                        board[i][j] = 'X';
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        SurroundedRegions surroundedRegions = new SurroundedRegions();
        char[][] board = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
                { 'X', 'O', 'X', 'X' } };
        char[][] inputArray = {
                { 'X', 'O', 'X', 'O', 'X', 'O' },
                { 'O', 'X', 'O', 'X', 'O', 'X' },
                { 'X', 'O', 'X', 'O', 'X', 'O' },
                { 'O', 'X', 'O', 'X', 'O', 'X' }

        };
        surroundedRegions.solve(inputArray);
        System.out.println(board);
    }
}