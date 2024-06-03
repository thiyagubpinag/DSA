package Recursion;

public class GridPuzzle {
    static int count=0;
    public static int gridpuzzle_I(int m, int n) {
        gridpuzzle_I(0,0,m,n);
        return count;
    }

    public static void gridpuzzle_I(int x1,int x2,int y1,int y2){

        if(x1==y1-1 && x2==y2-1){
            count++;
            return;
        }
        if(safe(x1,x2,y1,y2)){

            gridpuzzle_I(x1+1,x2,y1,y2);
            gridpuzzle_I(x1,x2+1,y1,y2);

        }

    }

    public static boolean safe(int x1, int x2, int y1, int y2){
        return x1<y1 && x2<y2;
    }

    public static void main(String[] args) {
        int m=3;
        int n=2;
        int res=gridpuzzle_I(m,n);
        System.out.println(res);
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        // Base case: Only one way to reach the top-left corner (if not an obstacle)
        dp[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;

        // Fill the first row (ways to reach any cell in the first row)
        for (int j = 1; j < n; j++) {
            dp[0][j] = (dp[0][j - 1] == 1 && obstacleGrid[0][j] == 0) ? 1 : 0; // Check for obstacles
        }

        // Fill the first column (ways to reach any cell in the first column)
        for (int i = 1; i < m; i++) {
            dp[i][0] = (dp[i - 1][0] == 1 && obstacleGrid[i][0] == 0) ? 1 : 0; // Check for obstacles
        }

        // Fill the rest of the table using the DP equation
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = (obstacleGrid[i - 1][j] == 0 ? dp[i - 1][j] : 0) +
                        (obstacleGrid[i][j - 1] == 0 ? dp[i][j - 1] : 0);
            }
        }

        return dp[m - 1][n - 1];
    }
}
