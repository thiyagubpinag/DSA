package csesproblemset.search_sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class RestaurentCustomers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arrStr1 = sc.nextLine().split(" ");
        int n = Integer.parseInt(arrStr1[0]);
        int[][] input = new int[n][2];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            String[] arrStr = sc.nextLine().split(" ");
            input[i][0] = Integer.parseInt(arrStr[0]);
            input[i][1] = Integer.parseInt(arrStr[1]);
            max = Math.max(max, Math.max(input[i][0], input[i][1]));
        }

        int[] dp = new int[max+1];
        Arrays.fill(dp, 0);
        for (int[] in : input) {
            dp[in[0]]++;
            dp[in[1]]--;
        }

        int count = 0;
        int sum = 0;
        for (int i = 0; i < max; i++) {
            sum += dp[i];
            count = Math.max(count, sum);
        }
        System.out.println(count);

    }
}
