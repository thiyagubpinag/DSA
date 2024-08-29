package com.cses;

import java.util.ArrayList;
import java.util.List;

public class CountInversions {
    static int count=0;
    public static void merge(int[] a,int low,int mid,int high){
        List<Integer> temp=new ArrayList();

        int left=low;
        int right=mid+1;

        while(left<=mid && right<=high){
            if(a[left]<a[right]){
                temp.add(a[left++]);
            }else{
                count +=(mid-left+1);
                temp.add(a[right++]);
            }
        }

        while(left<=mid){
            temp.add(a[left++]);
        }


        while(right<=high){
            temp.add(a[right++]);
        }
        int index=0;
        for(int i=low;i<=high;i++){
            a[i]=temp.get(index++);
        }
    }

    public static void mergeSort(int[] a, int low, int high){
        if(low>=high) return;
        int mid=low+(high-low)/2;
        mergeSort(a,low,mid);
        mergeSort(a,mid+1,high);
        merge(a,low,mid,high);
    }

    public static int numberOfInversions(int []a, int n) {
        // Write your code here.
        mergeSort(a,0,n-1);
        return count;
    }

    public static void main(String[] args) {
        int res=numberOfInversions(new int[]{4, 3, 2, 1},4);
        System.out.println(res);
    }
}
