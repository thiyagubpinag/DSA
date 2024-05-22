package array;

public class BlockSum {
    public static int[][] matrixBlockSum(int[][] mat, int k) {
        int[][] res = new int[mat.length][];
        for (int i = 0; i < mat.length; i++) {
            res[i]=new int[mat[i].length];
            for (int j = 0; j < mat[i].length; j++) {
                res[i][j]=getSum(mat,i,j,k);
            }
        }
        return res;
    }

    private static int getSum(int[][] mat, int i, int j, int k) {
        int leftRow= Math.max(i - k, 0);
        int leftColumn= Math.max(j - k, 0);
        int rightRow=i+k>=mat.length? mat.length-1 :i+k;
        int rightCol;

        int sum=0;
        for(int x=leftRow;x<=rightRow;x++){
            rightCol=j+k>=mat[x].length? mat[x].length-1 :j+k;
            for(int y=leftColumn;y<=rightCol;y++){
                sum+=mat[x][y];
            }
        }

        return sum;

    }

    public static void main(String[] args) {
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        int k = 2;
        int[][] res=matrixBlockSum(mat,k);
        for(int i=0;i<res.length;i++){
            for(int j=0;j<res[i].length;j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }
}
