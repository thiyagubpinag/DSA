package array;

import java.util.Arrays;

public class AlternatePandE {
    static int positiveIndex = Integer.MIN_VALUE;

    public static void alternatePandE(int[] ar) {
        Arrays.sort(ar);
        int partitionZero = getPartition(ar, 0, ar.length, 0);
        int odd = 0;
        int even = partitionZero == ar.length ? positiveIndex + 1 : partitionZero - positiveIndex - 1;

        while (odd <= positiveIndex || even <= partitionZero) {
            if (odd <= positiveIndex) {
                System.out.print(ar[odd] + " ");
                odd++;
            }
            if (even <= partitionZero) {
                System.out.print(ar[even] + " ");
                even++;
            }
        }
    }

    private static int getPartition(int[] ar, int low, int high, int pivot) {
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (ar[j] < 0) {
                positiveIndex = Math.max(positiveIndex, j);
            }
            if (ar[j] != pivot) {
                i++;
                swapArr(ar, i, j);
            }
        }
        return i + 1;
    }

    private static void swapArr(int[] ar, int i, int j) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    public static void main(String[] args) {
        alternatePandE(new int[]{0 ,-3, 5, 9, -4, 10, -6});
    }
}
