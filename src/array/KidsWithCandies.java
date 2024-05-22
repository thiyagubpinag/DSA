package array;

import java.util.ArrayList;
import java.util.List;

public class KidsWithCandies {
    public static void main(String[] args) {
        int[] candies = {2,3,5,1,3};
        int extraCandies = 3;
        List<Boolean> resultList = kidsWithCandies(candies, extraCandies);
        System.out.println(resultList);
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> resultList = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < candies.length; i++) {
            if (max < candies[i]) {
                max = candies[i];
            }
        }
        for (int i = 0; i < candies.length; i++) {
            resultList.add(candies[i] + extraCandies >= max);
        }
        return resultList;

    }
}
