package test;

import java.util.HashMap;
import java.util.Map;

public class GreedyApproach {
    public static void main(String[] args) {
        String a = "11011";
        //sum of 1
        int res = Math.min(getFlip(a, '1'), getFlip(a, '0'));
        System.out.println(res);
        numberOfArithmeticSlices(new int[]{2, 4, 6, 8, 10});

    }

    static int getFlip(String a, char input) {
        int sumOf1 = 0;
        for (int i = 0; i < a.length(); i++)
            if (a.charAt(i) == input) sumOf1++;
        int rightOf1 = 0;
        int leftOf1 = 0;
        int temp = sumOf1;
        int n = a.length() - 1;
        while (temp-- > 0) {
            if (a.charAt(n--) == input) {
                rightOf1++;
            } else {
                leftOf1++;
            }
        }
        int leftMoreIndex = 0;
        while (n > 0) {
            if (a.charAt(n--) != input) {
                break;
            } else {
                leftMoreIndex++;
            }
        }
        rightOf1 += leftMoreIndex;
        return sumOf1 == rightOf1 ? leftOf1 : (sumOf1 - rightOf1) * 2;
    }


    public static int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int result = 0;
        Map<Integer, Integer>[] dp = new Map[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - nums[j];
                if (diff >= Integer.MIN_VALUE && diff <= Integer.MAX_VALUE) {
                    int d = (int) diff;
                    int countJ = dp[j].getOrDefault(d, 0);
                    int countI = dp[i].getOrDefault(d, 0);
                    dp[i].put(d, countI + countJ + 1);
                    result += countJ;
                }
            }
        }

        return result;
    }

}
