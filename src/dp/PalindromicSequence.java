package dp;

public class PalindromicSequence {
    public static void main(String[] args) {
        String a = "ababbbabbababa";
        int res = palindromicSequence(a,0,a.length()-1);
        System.out.println(res);

    }

    static int palindromicSequence(String str, int i, int j) {
        // Base case: If the substring is empty or a
        // palindrome, no cuts needed
        if (i >= j || isPalindrome(str, i, j))
            return 0;

        int minCuts = Integer.MAX_VALUE;

        // Iterate through all possible partitions and find
        // the minimum cuts needed
        for (int k = i; k < j; k++) {
            int cuts = palindromicSequence(str, i, k)
                    + palindromicSequence(str, k + 1, j) + 1;
            minCuts = Math.min(minCuts, cuts);
        }

        return minCuts;
    }

    static boolean isPalindrome(String str, int i, int j)
    {
        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}

