package array;

import java.util.Arrays;

public class MinOperation {
    static int minimumOperations(int[] a, int[] b) {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<b.length;i++){
            int operation=0;
            for(int j=i+1;j<b.length;j++){
                operation+=(b[j]-b[i]);
            }
            int k=0;
            while(k<a.length && a[k]<b[i] ){
                operation+=(b[i]-a[k]);
                k++;
            }
            min=Math.min(min,operation);
        }
        return min;

    }

    public static void main(String[] args) {
        int[] a={2,3};
        int[] b={3,5};
        int res=minimumOperations(a,b);
        System.out.println(res);
    }
}
