package array;

public class MinCostBinarySearch {

    public static int minCost(int[] coins, int c2) {
        int n = coins.length;
        int totalCoins = 0;
        for (int coin : coins) {
            totalCoins += coin;
        }

        // Handle edge cases: if there are no coins (totalCoins = 0) or only one pile (n = 1)
        if (totalCoins == 0 || n == 1) {
            return 0;
        }

        // Find the lower and upper bounds for binary search
        int low = 0;
        int high = totalCoins; // Maximum possible number of coins to remove from all piles

        while (low < high) {
            int mid = low + (high - low) / 2;

            // Check if it's possible to make all piles equal with the current mid value
            if (isPossible(coins, mid, c2)) {
                high = mid; // Reduce search space to the left side (lower cost)
            } else {
                low = mid + 1; // Increase search space to the right side (higher cost)
            }
        }

        return low * c2; // Minimum cost is the number of coins removed (low) multiplied by cost per removal (c2)
    }

    private static boolean isPossible(int[] coins, int targetCoins, int c2) {
        int n = coins.length;
        int extraCoins = 0; // Tracks the total number of coins to be removed

        // Iterate through each pile
        for (int coin : coins) {
            // Calculate the difference between the current pile and the target
            int diff = Math.max(coin - targetCoins, 0); // Consider only positive differences (coins to remove)
            extraCoins += diff;
        }

        // Check if it's possible to remove 'extraCoins' from all piles without violating the constraint
        // (i.e., removing a coin from a pile with zero coins)
        return extraCoins <= targetCoins;
    }

    public static void main(String[] args) {
        int[] coins = {1, 5, 10};
        int c2 = 1;
        System.out.println(minCost(coins, c2)); // Output: 9
    }
}

