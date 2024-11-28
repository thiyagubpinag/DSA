public class MinHeightShelves {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int sumOfWidth = 0;
        int sumOfHeight = 0;

        for (int[] book : books) {
            sumOfWidth += book[0];
            sumOfHeight = book[1];
        }

        int[][][] dp = new int[books.length + 1][sumOfWidth + 1][sumOfHeight + 1];
        for (int i = 0; i <= books.length; i++) {
            for (int j = 0; j <= sumOfWidth; j++) {
                for (int k = 0; k <= sumOfHeight; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        int res = minHeightShelvesHelper(books, 1, books[0][0], books[0][1], shelfWidth, dp);
        return res;

    }

    public int minHeightShelvesHelper(int[][] books, int index, int width, int height, int shelfWidth, int[][][] dp) {
        if (index == books.length) {
            return height;
        }
        if (dp[index][width][height] != -1) {
            return dp[index][width][height];
        }
        int minValue = Integer.MAX_VALUE;
        if (width + books[index][0] <= shelfWidth) {
            int include = minHeightShelvesHelper(books, index + 1, width + books[index][0],
                    Math.max(height, books[index][1]), shelfWidth, dp);
            minValue = Math.min(minValue, include);
            int exclude = height + minHeightShelvesHelper(books, index + 1, books[index][0], books[index][1],
                    shelfWidth, dp);
            minValue = Math.min(minValue, exclude);
        } else {
            int exclude = height + minHeightShelvesHelper(books, index + 1, books[index][0], books[index][1],
                    shelfWidth, dp);
            minValue = Math.min(minValue, exclude);
        }
        return dp[index][width][height] = minValue;
    }

    public static void main(String[] args) {
        int[][] books = { { 1, 1 }, { 3, 3 }, { 1, 5 }, { 1, 7 } };

        int shelfWidth = 4;
        MinHeightShelves minHeightShelves = new MinHeightShelves();
        int res = minHeightShelves.minHeightShelves(books, shelfWidth);
        System.out.println(res);
    }
}
