package array;

import java.util.Arrays;

public class ShipPackage {
    public static boolean accept(int mid, int[] weights, int d) {
        int count = 1;
        int n = weights.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += weights[i];
            if (sum > mid) {
                sum = weights[i];
                count += 1;
            }
            if (count > d) {
                return false;
            }
        }

        return true;

    }

    public static int leastWeightCapacity(int[] weights, int d) {
        // Write your code here.
        int sum = Arrays.stream(weights).sum();
        int max = Arrays.stream(weights).max().getAsInt();
        int low = 1;
        int high = sum;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (accept(mid, weights, d)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return Math.max(ans, max);

    }

    public static void main(String[] args) {
        int[] input = {86, 45, 74, 64, 14, 68, 44, 11, 43, 33, 8, 20};
        int res = leastWeightCapacity(input, 12);
        System.out.println(res);
    }
}
