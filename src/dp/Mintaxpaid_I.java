package dp;

public class Mintaxpaid_I {
    public static int mintaxpaid_I(int[][] matrix) {
        //Write your code here
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] cost = new int[m][n];
        int sum=0;
        for (int i = 0; i < n; i++) {
            sum+=matrix[0][i];
            cost[0][i] =sum;
        }
        sum=0;
        for (int i = 0; i < m; i++) {
            sum+=matrix[i][0];
            cost[i][0] =sum;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                cost[i][j]=Math.min(cost[i-1][j],cost[i][j-1])+matrix[i][j];
            }
        }


        return cost[m-1][n-1];
    }

    public static void main(String[] args) {
        int m = 2;
        int n = 3;
        int[][] arr = new int[][]{{5, 9, 2}, {11, 5, 6}};
        System.out.println(mintaxpaid_I(arr));
    }
}
