package array;

import java.util.HashSet;

public class DistinctNumbers {
    public static void main(String[] args) {
        int[] arr={2,3,3,2,3};

        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }

        System.out.println(set.size());
    }
}
