package dp;

import java.util.ArrayList;
import java.util.List;

public class PalindromicSequence {
    static List<String> resultList = new ArrayList<>();

    public static void main(String[] args) {
        String a = "aab";
        char[] c=a.toCharArray();
        String b=new String(c);
        System.out.println(b);
        palindromicSequence(a, 0, a.length() - 1);
        System.out.println(resultList);

    }

    static void palindromicSequence(String str, int i, int j) {
        // Base case: If the substring is empty or a
        // palindrome, no cuts needed
        if (i > j) {
            return;
        }
        if (isPalindrome(str, i, j)) {
            resultList.add(str.substring(i, j + 1));
        }

        for (int k = i; k < j; k++) {
            palindromicSequence(str, i, k);
            palindromicSequence(str, k + 1, j);
        }
    }

    static boolean isPalindrome(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}

