package array;

import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

public class LongestConsecutiveSequence {
    public static int longestConsecutiveSequence(int[] arr) {
        //Write your code here
        int n = arr.length;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
        }

        AtomicInteger ans = new AtomicInteger(Integer.MIN_VALUE);
        AtomicInteger lastValue = new AtomicInteger(Integer.MIN_VALUE);
        AtomicInteger count = new AtomicInteger(1);
        set.forEach(i -> {
            if (i == lastValue.get() + 1) {
                count.getAndIncrement();
                if (ans.get() < count.get()) {
                    ans.set(count.get());
                }
            } else {
                count.set(1);
            }
            lastValue.set(i);
        });

        return ans.get();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6 ,10, 11, 7, 8, 9};
        int res = longestConsecutiveSequence(arr);
        System.out.println(res);
    }
}
