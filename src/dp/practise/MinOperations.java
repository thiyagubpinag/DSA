package dp.practise;

import java.util.ArrayList;
import java.util.List;

public class MinOperations {

    public static boolean check(List<Integer> change, List<Integer> arr, int last) {
        int n = arr.size(), balance = 0;
        boolean[] deleted = new boolean[n];
        for (int i = last; i >= 0; i--) {
            if (change.get(i) == 0 || deleted[change.get(i) - 1]) {
                if (balance > 0) {
                    balance--;
                }
            } else {
                deleted[change.get(i) - 1] = true;
                n--;
                balance += arr.get(change.get(i) - 1);
            }
        }
        return n == 0 && balance == 0;
    }

    public static int getMinOperations(List<Integer> change, List<Integer> arr) {
        int left = 0;
        int right = change.size() - 1;
        if (!check(change, arr, right)) {
            return -1;
        }
        while (left<right) {
            int mid = (right + left) / 2;
            if (check(change, arr, mid)) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return right + 1;
    }

    public static void main(String[] args) {
        List<Integer> change1 = new ArrayList<>(List.of(1, 0, 1, 3, 2, 1, 0, 3, 1, 1));
        List<Integer> arr1 = new ArrayList<>(List.of(2, 1, 2));
        System.out.println(getMinOperations(change1, arr1)); // 8

        List<Integer> change2 = new ArrayList<>(List.of(0, 0, 0, 2, 1, 3, 2));
        List<Integer> arr2 = new ArrayList<>(List.of(1, 3, 2));
        System.out.println(getMinOperations(change2, arr2)); // -1

        List<Integer> change3 = new ArrayList<>(List.of(1));
        List<Integer> arr3 = new ArrayList<>(List.of(0));
        System.out.println(getMinOperations(change3, arr3)); // 1
    }
}