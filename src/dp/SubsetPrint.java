package dp;

import java.util.ArrayList;

public class SubsetPrint {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 5, 2, 7, 10}; int sum = 10;
        int n = arr.length;
        boolean[][] T = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            T[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                T[i][j] = T[i - 1][j];
                if (j - arr[i - 1] >= 0) {
                    T[i][j] = T[i - 1][j] || T[i - 1][j - arr[i - 1]];
                }
            }
        }

        ArrayList<Integer> a = new ArrayList<>();
        printSubset(T, arr, n, sum, a);

    }

    private static void printSubset(boolean[][] T, int[] arr, int n, int sum, ArrayList<Integer> a) {
        if (n == 0 && sum != 0 && T[n][sum]) {
            a.add(arr[n]);
            System.out.println(a);
            return;
        }
        if (sum == 0) {
            System.out.println(a);
            return;
        }
        if (T[n - 1][sum]) {
            ArrayList<Integer> b = new ArrayList<>();
            b.addAll(a);
            printSubset(T, arr, n - 1, sum, b);
        }

        if (sum - arr[n - 1] >= 0) {
            a.add(arr[n - 1]);
            printSubset(T, arr, n - 1, sum - arr[n - 1], a);
        }

    }
}
