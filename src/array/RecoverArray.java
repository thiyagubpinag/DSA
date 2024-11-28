package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RecoverArray {
    int[] output;
    boolean flag = false;

    public void subset(int[] sums, int n, int i, int sum, List<Integer> itList) {
        if (sum == 0 && itList.size() == n) {
            int index = 0;
            for (Integer it : itList) {
                output[index++] = it;
            }
            flag = true;
        }
        if (i < 0) {
            return;
        }
        if (flag) {
            return;
        }
        subset(sums, n, i - 1, sum, itList);
        itList.add(sums[i]);
        subset(sums, n, i - 1, sum + sums[i], itList);
        itList.removeLast();
    }



    public int[] recoverArray(int n, int[] sums) {
        List<Integer> temp = new ArrayList<>();
        output = new int[n];
        subset(sums, n, sums.length - 1, 0, temp);
        return output;
    }

    public static void main(String[] args) {
        RecoverArray recoverArray = new RecoverArray();
        int n=3;
        int[] output=recoverArray.recoverArray(n, new int[]{-3, -2, -1, 0, 0, 1, 2, 3});
        for (int i=0;i<n;i++){
            System.out.print(output[i]+" ");
        }
    }
}
