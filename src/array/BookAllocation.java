package array;

public class BookAllocation {

    static int min = Integer.MAX_VALUE;
    static int max=Integer.MIN_VALUE;

    public static void bookAllocate(int index, int k, int[] arr, int sum, int[] suffixSum) {
        if (k == 1) {
            max=Integer.max(sum,suffixSum[index]);
            min = Math.min(min,max);
            return;
        }
        int temp = 0;
        for (int i = index; i <= arr.length - k; i++) {
            sum += arr[i];
            bookAllocate(i + 1, k - 1, arr, sum + temp, suffixSum);
        }
    }


    public static void main(String[] args) {
        int[] a = {12, 34, 67, 90,12,100};
        int m = 4;
        int[] suffixSum = new int[a.length];
        int sum = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            sum += a[i];
            suffixSum[i] = sum;
        }
        bookAllocate(0, m, a, 0, suffixSum);
        System.out.println(min);
    }
}
