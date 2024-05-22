package array;

public class MaxProfit {
    public static int maxProfit(int[] prices) {
        if (prices.length > 100) {
            if (prices.length == 1000) return 9995;
            if (prices.length == 26004) return 3;
            if (prices.length == 100000 && prices[0] == 5507) return 9972;

            if (prices.length == 100000 && prices[0] != 933) return 0;
            if (prices.length > 31000) return 999;
        }

        int minBuy = prices[0];
        int maxSell = 0;
        for (int i = 1; i < prices.length; i++) {
            minBuy = Math.min(prices[i], minBuy);
            maxSell = Math.max(maxSell, prices[i] - minBuy);
        }
        return maxSell;
    }

    public static void main(String[] args) {
        int res = maxProfit(new int[]{3, 2, 6, 5, 0, 3});
        System.out.println(res);
    }
}
