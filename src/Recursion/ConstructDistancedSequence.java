package Recursion;

import java.util.*;

public class ConstructDistancedSequence {
    public static int[] constructDistancedSequence(int n) {
        count = new int[2 * n - 1];
        ans = new int[2 * n - 1];
        int[] input = new int[2 * n - 1];
        input[0] = 1;
        int k = 2;
        int i = 1;
        while (i < 2 * n - 1) {
            input[i++] = k;
            input[i++] = k++;
        }
        findMaxSequence(count, input.length - 1, input);
        return ans;
    }

    private static boolean findMaxSequence(int[] count, int n, int[] input) {
        if (n == -1) {
            boolean flag = false;
            int sum = 0;
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < count.length; i++) {
                sum += count[i];
                if (!set.contains(count[i])) {
                    int index = count[i];
                    if (index + i < ans.length) {
                        if (index != 1 && count[i] != count[i + index]) {
                            flag = true;
                        }
                    } else {
                        flag = true;
                    }
                }
                set.add(count[i]);
            }
            if (!flag && max < sum) {
                max = sum;
                ans = Arrays.copyOf(count, count.length);
                return true;
            }
            return false;
        }


        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                count[i] = input[n];
                if (findMaxSequence(count, n - 1, input)) {
                    return true;
                }
                count[i] = 0;
            }
        }
        return false;
    }

    public static int max = Integer.MIN_VALUE;
    public static int[] count;
    public static int[] ans;

    public static void main(String[] args) {
        int n = 2;
        int[] arr = constructDistancedSequence(n);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
