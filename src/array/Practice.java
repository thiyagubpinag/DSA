package array;

import java.util.*;

public class Practice {
    public static void main(String[] args) {

        int[] a=new int[]{1,3,5,7,9,10};
        int i=Arrays.binarySearch(a,8);
        System.out.println(-(i+1));
        System.out.println(i);
    }

}
