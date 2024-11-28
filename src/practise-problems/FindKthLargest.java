package test;

import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;

public class FindKthLargest {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        for (Integer key : nums) {
            pq.add(key);
        }
        while (k-- > 1) {
            pq.remove();
        }
        return pq.remove();

    }

    public static void main(String[] args) {
        int[] a = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        findKthLargest(a, 4);
    }
}
