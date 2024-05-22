package array;

import java.util.Arrays;

public class MaximumTastiness {
    public static int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int n=price.length;
        if(k==1){
            return price[0];
        }
        int low=0;
        int high=price[n-1]-price[0];
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(maxTastiness(mid,price,k)){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;


    }

    public static boolean maxTastiness(int mid,int[] price,int k){
        int prevElement=price[0];
        int counter=1;
        for(int i=1;i<price.length;i++){
            if(price[i]-prevElement>=mid){
                counter++;
                prevElement=price[i];
                if(counter==k){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
       int[] arr={13,5,1,8,21,2};
       int k=3;
        System.out.println(maximumTastiness(arr,k));
    }
}
