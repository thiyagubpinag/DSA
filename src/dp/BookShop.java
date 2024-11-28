package dp;

public class BookShop {


    static int totalPrice;

    public static void main(String[] args) {
        totalPrice = 10;
        int[] price = {4, 8, 5, 3};
        int[] pages = {5, 14, 8, 1};
        int res=subset(price,pages,0,3,0);
        System.out.println(res);

    }


    public static int subset(int[] price, int[] pages, int start, int n, int result) {
        if (start > totalPrice || n < 0) {
            return result;
        }
        if (start + price[n] > totalPrice) {
            return subset(price, pages, start, n - 1, result);
        }

        return Math.max(
                subset(price, pages, start, n - 1, result),
                subset(price, pages, start + price[n], n - 1, result + pages[n])
        );

    }
}
