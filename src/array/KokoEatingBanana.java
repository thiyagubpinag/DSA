package array;

public class KokoEatingBanana {
    public static boolean getPiles(int[] piles, int mid, int h, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (piles[i] / mid);
            if (piles[i] % mid != 0) sum += 1;
        }
        return sum <= h;
    }

    public static int minEatingSpeed(int low, int high, int[] piles, int n, int h) {
        int ans = -1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (getPiles(piles, mid, h, n)) {
                high = mid - 1;
                ans = mid;
            } else {
                low = mid + 1;
            }

        }
        return ans;
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        int n = piles.length;
        for (int i = 0; i < n; i++)
            max = Math.max(max, piles[i]);

        int low = 1;
        int high = max;

        return minEatingSpeed(low, high, piles, n, h);

    }

    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        int res = minEatingSpeed(piles, h);
        System.out.println(res);
    }
}
