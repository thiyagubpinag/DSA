package bit.manipulation;

import java.util.ArrayList;
import java.util.List;

public class PrintSubsets {
    public static void printSubset(int n, int[] a, List<Integer> result) {
        if (n < 0) {
            System.out.println(new ArrayList<>(result));
            return;
        }

        printSubset(n - 1, a, new ArrayList<>(result));
        result.add(a[n]);
        printSubset(n - 1, a, result);
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};

        printSubset(a.length-1,a,new ArrayList<>());
    }
}
