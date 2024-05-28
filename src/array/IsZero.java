package array;

import java.util.Arrays;
import java.util.HashSet;

public class IsZero {
    static boolean isZero(int[] arr, int N) {
        //Write your code here
        Arrays.sort(arr);
        int point = Arrays.binarySearch(arr, 0);
        int key = (-(point) - 1);
        if (arr[key] == 0) {
            return true;
        }
        if (key == 0) {
            return false;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int ar : arr) {
            set.add(ar);
        }

        int left = key;
        int leftSum = 0;
        while (left-- > 0) {
            leftSum += (-arr[left]);
            if (set.contains(leftSum)) {
                return true;
            }
        }


        return false;


    }

    public static void main(String[] args) {
        System.out.println(isZero(new int[]{1, 4, -2, -2, 5, -4, 3}, 7));
    }
}
