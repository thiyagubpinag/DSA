package dp;

public class SticklerThief {
    public static int FindMaxSum(int arr[], int n) {
        return findMax(arr, n - 1, 0);
    }

    public static int findMax(int arr[], int n, int sum) {
        if (n < 0) {
            return sum;
        }

        return Math.max(findMax(arr, n - 1, sum) ,findMax(arr, n - 2, sum + arr[n]));

    }

    public static void main(String[] args) {
        int a[] = {6,5,5,7,4};
        int n=a.length;
        int res=FindMaxSum(a,n);
        System.out.println(res);
    }
}
