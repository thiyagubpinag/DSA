package array;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] a={1,4,6,7};
        int b=Arrays.binarySearch(a,9);
        System.out.println(-(b)-1);
    }
}
