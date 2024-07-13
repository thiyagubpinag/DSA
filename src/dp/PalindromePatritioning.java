package dp;

import static dp.PalindromicSequence.isPalindrome;

public class PalindromePatritioning {
    public static void main(String[] args) {
        String a = "geeksee";
        int res = palindromeParti(a, 0, a.length() - 1);
        System.out.println(res);
    }

    private static int palindromeParti(String a, int start, int end) {
        if (start > end) {
            return 0;
        }
        if (isPalindrome(a, start, end)) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            ans = Math.min(ans, palindromeParti(a, start, i) + palindromeParti(a, i + 1, end) + 1);
        }
        return ans;
    }


}
