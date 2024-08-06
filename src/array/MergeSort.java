package array;

import java.util.Arrays;

public class MergeSort {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j=n-1;
        for(int i=m-1;i>=0;i--){
            if(j>=0){
                nums1[i]=nums2[j--];
            }else{
                break;
            }
        }
        Arrays.sort(nums1);
    }

    public static void main(String[] args) {

    }
}
