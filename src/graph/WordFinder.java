package graph;

public class WordFinder {
    static int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) {
        char[][] board = {{'a', 'g', 'b', 'c' }, {'q', 'e', 'e', 'l' }, {'g', 'b', 'k', 's' }};
        String word = "geeks";
        if (findWord(word, board)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean findWord(String word, char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (word.charAt(0) == board[i][j] && (dfsUtils(1, board, word, i, j, visited))) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfsUtils(int index, char[][] board, String word, int i, int j, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        visited[i][j] = true;
        for (int x = 0; x < 4; x++) {
            int newX = direction[x][0] + i;
            int newY = direction[x][1] + j;
            if (isValid(newX, newY, board, visited) && word.charAt(index) == board[newX][newY]) {
                if (dfsUtils(index + 1, board, word, newX, newY, visited)) {
                    return true;
                }
            }
        }
        visited[i][j] = false;
        return false;
    }

    private static boolean isValid(int i, int j, char[][] board, boolean[][] visited) {
        if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && !visited[i][j]) {
            return true;
        }
        return false;
    }
}
