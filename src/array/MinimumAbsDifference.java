package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsDifference {
    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList();
        int min = Integer.MAX_VALUE;
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            if ((arr[i] - arr[i - 1]) < min) {
                min = arr[i]-arr[i-1];
            }
        }

        for (int i = 1; i < n; i++) {
            if ((arr[i] - arr[i - 1]) == min) {
                result.add(List.of(arr[i], arr[i - 1]));
            }

        }
        return result;


    }

    public static void main(String[] args) {
        List<List<Integer>> result=minimumAbsDifference(new int[]{4, 2, 1, 3});
    }
}
