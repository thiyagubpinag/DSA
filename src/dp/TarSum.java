package dp;

public class TarSum {
    static int count=0;
    public static int targetSum(int n, int target, int[] arr) {
        // Write your code here.
        target(n-1,0,arr,target);
        return count;
    }
    public static void target(int n, int sum, int[] arr,int target) {
        if(sum==target){
            count++;
            return;
        }
        // Write your code here.
        if(n<0){
            return;
        }
        target(n-1,sum+arr[n],arr,target);
        target(n-1,sum-arr[n],arr,target);
    }
}
