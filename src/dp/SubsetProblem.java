package dp;

import java.util.ArrayList;
import java.util.List;

public class SubsetProblem {
    static List<List<Integer>> resultList = new ArrayList<>();

    public static void subset(int n, int[] arr, List<Integer> input) {
        if (n < 0) {
            resultList.add(input);
            return;
        }
        subset(n - 1, arr, new ArrayList<>(input));
        List<Integer> temp=new ArrayList<>(input);
        temp.add(arr[n]);
        subset(n - 1, arr, temp);

    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        subset(a.length - 1, a, new ArrayList<>());
        System.out.println(resultList);
    }
}
