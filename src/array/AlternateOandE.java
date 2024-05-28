package array;

import java.util.Arrays;

public class AlternateOandE {
    public static void alternateOandE(int[] nums) {
        int n = nums.length;
        int[] even = new int[(n + 1) / 2];
        int[] odd = new int[n / 2];
        int iE = 0;
        int iO = 0;

        for(int i = 0; i < n; i++) {
            if(nums[i] % 2 == 0) {
                even[iE++] = nums[i];
            } else {
                odd[iO++] = nums[i];
            }
        }

        Arrays.sort(even);
        Arrays.sort(odd);
        iE = 0;
        iO = 0;

        for(int i = 0; i < n; i++) {
            if(i % 2 != 0) {
                System.out.print(even[iE++] + " ");
            } else {
                System.out.print(odd[iO++] + " ");
            }
        }


    }

    private static void swapAr(int[] ar, int i, int j) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {6,5,3, 2, 1,4};
        alternateOandE(a);
    }
}
