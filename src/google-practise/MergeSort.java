public class MergeSort {
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    static boolean merge(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
        boolean[] res = new boolean[2];
        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Merge the temp arrays

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        int count = 1;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                count += (n2 - j);
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }

        return count > 2;
    }

    // Main function that sorts arr[l..r] using
    // merge()
    static boolean sort(int arr[], int l, int r) {
        if (l < r) {

            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            boolean left = sort(arr, l, m);
            boolean right = sort(arr, m + 1, r);
            if (left || right) {
                return true;
            }
            // Merge the sorted halves
            return merge(arr, l, m, r);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 0, 4, 2, 1, 0, -1, -3 };
        boolean res = sort(arr, 0, arr.length - 1);
        System.out.println(res);
    }

}
