package array;

import java.util.*;

public class PrintFirstNegativeInteger {
    static void printFirstNegativeInteger(List<Integer> arr, int k) {
        int window_size = 0;
        ArrayList<Integer> res = new ArrayList();
        int left = 0;
        TreeSet<Integer> set = new TreeSet();
        for (int i = 0; i < arr.size(); i++) {
            set.add(arr.get(i));
            window_size++;
            if (window_size == k) {
                int value = set.first() < 0 ? set.lower(0) : 0;
                res.add(value);
                set.remove(arr.get(left));
                left++;
                window_size--;
            }
        }

        res.forEach(i -> {
            System.out.print(i + " ");
        });
    }

    public static void main(String[] args) {
        int[] ints = {12, -1, -7, 8, -15, 30, 16, 28};
        List<Integer> intList = new ArrayList<Integer>(ints.length);
        for (int i : ints) {
            intList.add(i);
        }
        printFirstNegativeInteger(intList, 3);
    }
}
