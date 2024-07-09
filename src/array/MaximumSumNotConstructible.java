package array;

import java.util.Arrays;

public class MaximumSumNotConstructible {

    // Function to find the maximum sum which we cannot
    // construct using given coins
    static long solve(long[] arr, int N) {
        // Variable to store the maximum value of the next coin
        long X = 1;

        // Sort the coins in ascending order of their values
        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            // If the current coin's value is greater than X,
            // then X is the answer
            if (arr[i] > X) {
                return X;
            }
            // If current coin's value is less than or equal to
            // X, then we can update X as X + arr[i]
            X += arr[i];
        }
        return X;
    }

    public static void main(String[] args) {
        // Sample Input
        int N = 5;
        long[] arr = {3, 9, 1, 2, 7};

        System.out.println(solve(arr, N));
    }
}
