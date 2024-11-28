package dp;

public class PalindromePartititon {

    public static int getMinCuts(String s, int start, int end) {
        if (start > end) {
            return 0;
        }
        if (isPalindrom(s, start, end)) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int k = start; k < end; k++) {
            int minCuts = 1 + getMinCuts(s, start, k) + getMinCuts(s, k + 1, end);
            min = Math.min(minCuts, min);
        }
        return min;
    }

    private static boolean isPalindrom(String s, int start, int end) {
        int low = start;
        int high = end;
        while (low <= high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;

    }

    public static void main(String[] args) {
        String a = "geekeeg";
        int res = getMinCuts(a, 0, a.length()-1);
        System.out.println(res);
    }
}
