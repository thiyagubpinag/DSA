package m2p;

public class Test3 {
    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int n = a.length;

        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int temp = a[i][j];
                a[i][j] = a[n - j - 1][i];
                a[n - j - 1][i] = a[n - i - 1][n - j - 1];
                a[n - i - 1][n - j - 1] = a[j][n - i - 1];
                a[j][n - i - 1] = temp;
            }
        }

        System.out.println(a);
    }
}
//
//
//0,0 - 3,0
//
//3,0  3,3
//
//3,3   0,3
//
//0,3  0,0
