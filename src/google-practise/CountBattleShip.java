import java.util.Arrays;
import java.util.Scanner;

public class CountBattleShip {

    public void dfs(int i, int j, Boolean[][] visited, char[][] board, int[] dir, int n, int m) {
        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int newI = i + dir[k];
            int newJ = j + dir[k + 1];

            if (newI >= 0 && newI < n && newJ >= 0 && newJ < m && !visited[newI][newJ]
                    && board[newI][newJ] != '.') {
                dfs(newI, newJ, visited, board, dir, n, m);
            }
        }
    }

    public int countBattleships(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        Boolean[][] visited = new Boolean[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], false);
        }

        int[] dir = new int[] { 0, 1, 0, -1, 0 };

        int count = 0; // 1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && board[i][j] != '.') {
                    count++;
                    dfs(i, j, visited, board, dir, n, m);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                { 'X', '.', '.', 'X' },
                { 'X', '.', '.', 'X' },
                { 'X', 'X', 'X', 'X' }
        };
        CountBattleShip countBattleShip = new CountBattleShip();
        int res = countBattleShip.countBattleships(matrix);
        System.out.println(res);

    }

}
