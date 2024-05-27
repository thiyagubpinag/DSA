package array;

public class MinDays {
    public static int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (m * k > n) {
            return -1;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            min = Math.min(bloomDay[i], min);
            max = Math.max(bloomDay[i], max);
        }

        int low = min;
        int high = max;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (getPossibleDay(bloomDay, m, mid, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;

    }

    static boolean getPossibleDay(int[] bloomDay, int boe, int noOfDays, int k) {
        int n = bloomDay.length;
        int noOfBouqets = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (bloomDay[i] <= noOfDays) {
                count++;
            } else {
                noOfBouqets += count / k;
                count = 0;
            }
        }
        noOfBouqets += count / k;
        return noOfBouqets >= boe;
    }

    public static void main(String[] args) {
        int[] arr = {5, 37, 55, 92, 22, 52, 31, 62, 99, 64, 92, 53, 34, 84, 93, 50, 28};
        int m = 8;
        int k = 2;
        int res = minDays(arr, m, k);
        System.out.println(res);
    }
}
