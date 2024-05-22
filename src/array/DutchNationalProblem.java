package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class DutchNationalProblem {
    public static void dutchNationalProblem(int[] arr) {
        List<Integer> arrList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            arrList.add(arr[i]);

        int partitionZero = getPartition(arrList, 0, arrList.size(), 0);
        int partitionOne = getPartition(arrList, partitionZero, arrList.size(), 1);
        System.out.println(arrList);

    }


    private static void swapArr(List<Integer> arrList, int i, int j) {
        int temp = arrList.get(i);
        arrList.set(i, arrList.get(j));
        arrList.set(j, temp);
    }

    public static void main(String[] args) {
        dutchNationalProblem(new int[]{0, 0, 0, 0, 1, 2, 2, 2, 1, 2});
    }

    private static int getPartition(List<Integer> arrList, int low, int high, int pivot) {
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arrList.get(j) == pivot) {
                i++;
                swapArr(arrList, i, j);
            }
        }
        swapArr(arrList, i + 1, high - 1);
        return i + 1;
    }

    public int solve(ArrayList<Integer> a, ArrayList<Integer> b) {
        AtomicInteger count = new AtomicInteger();
        Set<Integer> BSet = new HashSet<>();
        b.forEach(i->{
            BSet.add(i);
        });
        a.forEach(i->{
            if (BSet.contains(i)) {
                count.getAndIncrement();
            }
        });
        return count.get();


    }


}
