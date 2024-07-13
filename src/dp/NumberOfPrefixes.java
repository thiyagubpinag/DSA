package dp;

import java.util.Scanner;
import java.util.Vector;

public class NumberOfPrefixes {

    public static final int MOD = 1000000007;

    public static boolean isValid(int x, int m) {
        return (x >= 1 && x <= m);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();

        Vector<Integer> a = new Vector<>(n);
        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }


        Vector<Vector<Integer>> dp = new Vector<>(n + 1);
        for (int i = 0; i <= n; i++) {
            Vector<Integer> temp = new Vector<>();
            for (int j = 0; j <= m; j++) {
                temp.add(0);
            }
            dp.add(temp);
        }

        // dp[i][k] = number of ways to build a prefix of size i
        // such that the last element of the prefix is k

        // base case dp[1][k] = 1 if (a[0] == 0 OR a[0] == k)
        for (int i = 1; i <= m; i++) {
            if (a.getFirst() == i || a.getFirst() == 0) {
                dp.get(1).set(i, 1);
            }
        }

        for (int i = 2; i <= n; i++) {
            for (int k = 1; k <= m; k++) {
                // finding dp[i][k] here
                if (a.get(i - 1) != 0 && a.get(i - 1) != k) {
                    dp.get(i).set(k, 0);
                    continue;
                }

                int sum = 0;
                for (int prev = k - 1; prev <= k + 1; prev++) {
                    if (!isValid(prev, m)) {
                        continue;
                    }
                    // transition
                    sum = (sum + dp.get(i - 1).get(prev)) % MOD;
                }
                dp.get(i).set(k, sum);
            }
        }

        int ans = 0;
        for (int i = 1; i <= m; i++) {
            ans = (ans + dp.get(n).get(i)) % MOD;
        }

        // final subproblem
        System.out.println(ans);
    }
}
