package dp;

import java.util.Arrays;

public class DistinctSubseqII {
    public static int distinctSubseqII(String s) {
        int n = s.length();
        Long[] dp = new Long[n + 1];
        dp[0] = 1L;
        int[] temp = new int[26];
        Arrays.fill(temp, 0);
        for (int i = 1; i <= n; i++) {
            int index = s.charAt(i - 1) - 'a';
            if (temp[index] != 0) {
                int lastOccurence = temp[index];
                if (lastOccurence - 1 >= 0) {
                    dp[i] = (dp[i - 1] * 2) - dp[lastOccurence - 1];
                }
            } else {
                dp[i] = (dp[i - 1] * 2);
            }
            temp[index] = i;
        }

        return (dp[n]).intValue()-1;
    }

    public static void main(String[] args) {
        int a = distinctSubseqII("zchmliaqdgvwncfatcfivphddpzjkgyygueikthqzyeeiebczqbqhdytkoawkehkbizdmcnilcjjlpoeoqqoqpswtqdpvszfaksn");
        System.out.println(a);
    }
}
