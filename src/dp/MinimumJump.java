package dp;

import java.util.Arrays;

public class MinimumJump {
    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int n = 11;
        int jump[] = new int[n];
        Arrays.fill(jump, Integer.MAX_VALUE);
        jump[0]=1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j + arr[i] >= i) {
                    jump[i] = Math.min(jump[j] + 1, jump[i]);
                }
            }
        }

        System.out.println(jump[n-1]);
    }
}
