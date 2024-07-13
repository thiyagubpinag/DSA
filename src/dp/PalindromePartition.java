package dp;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
    public static void main(String[] args) {
        String a = "aab";
        getPalindrome(a, 1, a.length() - 2, new ArrayList<>());

    }

    private static ArrayList<String> getPalindrome(String a, int start, int end, ArrayList<String> list) {
        if (start > end) {
            list.add(String.valueOf(a.charAt(start)));
            return new ArrayList<>(list);
        }
        for (int i = start; i <= end; i++) {
            List<String> firstPartition=getPalindrome(a, start, i, new ArrayList<>(list));
            List<String> secondPartition=getPalindrome(a, i + 1, end, new ArrayList<>(list));
        }
        return list;
    }


}
