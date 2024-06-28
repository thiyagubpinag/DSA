package array;

public class StoneGame {
    public static boolean stoneGame(int[] piles) {
        int i = 0;
        int j = piles.length - 1;
        int sumA = 0;
        int sumB = 0;
        boolean flag = true;
        while (i <= j) {
            if (piles[i] > piles[j]) {
                if (flag) {
                    sumA += piles[i];
                } else {
                    sumB += piles[i];
                }
                i++;
            } else {
                if (flag) {
                    sumA += piles[j];
                } else {
                    sumB += piles[j];
                }
                j--;
            }
            flag = !flag;
        }

        if (sumA > sumB) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
       int[] piles={3,2,10,4};
        stoneGame(piles);
    }
}
