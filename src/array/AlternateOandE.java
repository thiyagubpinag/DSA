package array;

import java.util.Arrays;

public class AlternateOandE {
    public static void alternateOandE(int[] ar) {
        //Write your code here
        int low = 0;
        int high = ar.length;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (ar[j] % 2 != 0) {
                i++;
                swapAr(ar, i, j);
            }
        }
        int oddStart=0;
        int evenStart=i+1;
        Arrays.sort(ar,oddStart,evenStart);
        Arrays.sort(ar,evenStart,ar.length);
        while(oddStart<i+1 && evenStart<ar.length){
            System.out.print(ar[oddStart++]+" "+ar[evenStart++]+" ");
        }
        while(oddStart<i+1){
            System.out.print(ar[oddStart++]+" ");
        }
        while(evenStart<ar.length){
            System.out.print(ar[evenStart++]+" ");
        }


    }

    private static void swapAr(int[] ar, int i, int j) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {3, 1, 2};
        alternateOandE(a);
    }
}
