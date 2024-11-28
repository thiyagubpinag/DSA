package com.cses;

import java.util.Arrays;

public class MachineFactory {
    public static void main(String[] args) {
        // Sample Input
        long N = 3, T = 7;
        long[] K = {3, 2, 5};

        System.out.println(solve(N, T, K));
    }

    private static long solve(long n, long t, long[] k) {
        long min = Arrays.stream(k).min().getAsLong();
        long low = 1;
        long high = min * t;
        long ans = -1;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (ok(k, t, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;

    }

    private static boolean ok(long[] k, long t, long mid) {
        long sum = 0;
        for (int i = 0; i < k.length; i++) {
            sum += (mid/k[i]);
            if (sum > t) {
                return false;
            }
        }
        return sum <= t;
    }
}
