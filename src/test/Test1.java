package test;

import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {
        int[] nums1 = {1,3,4};
        int[] nums2 = {1,3,4};
        Arrays.stream(nums2).sum();
        int k = 1;
        System.out.println(numberOfPairs(nums1,nums2,k));
    }

    public static int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int count=0;
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(nums2[j]!=0 && isInteger((double) nums1[i] /(nums2[j]*k))){
                    count++;
                }
            }
        }
        return count;
    }

    public static final double EPSILON = 0.000001; // Define a small tolerance

    public static boolean isInteger(double value) {
        return Math.abs(value - Math.round(value)) < EPSILON;
    }
}
