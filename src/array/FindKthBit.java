package array;

import java.util.Arrays;
import java.util.Objects;

public class FindKthBit {
    public static char findKthBit(int n, int k) {
        String[] dp = new String[n];
        Arrays.fill(dp, "");
        String res = recursive(n, dp);

        return res.charAt(k);
    }

    public static String recursive(int n, String[] dp) {
        if (n == 1) {
            return "0";
        }
        return recursive(n - 1, dp) + 1 + reverseInvert(recursive(n - 1, dp));
    }

    public static String reverseInvert(String s) {
        char[] charArr = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            char temp = charArr[left];
            charArr[left] = charArr[right] == '0' ? '1' : '0';
            charArr[right] = temp == '0' ? '1' : '0';
            left++;
            right--;
        }
        return new String(charArr);
    }

    public static void main(String[] args) {
        System.out.println(findKthBit(4, 3));
    }
}
