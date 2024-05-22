package array;

public class MinimumTimeCook {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        int m = 11;
        int min=Integer.MAX_VALUE;
        int n=arr.length;
        for(int i=0;i<n;i++)
            min=Math.min(min,arr[i]);

        int low=0;
        int high=min*m;

        while(low<high){
            int mid=low+(high-low)/2;
            if(getOutputValue(arr,mid,m)){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        System.out.println(low);

    }

    private static boolean getOutputValue(int[] arr, int mid, int m) {
        int res=0;
        for(int i=0;i<arr.length;i++)
            res+=(mid/arr[i]);

        return res>=m;
    }
}
