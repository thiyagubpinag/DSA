public class Min {
    public int findMin(int[] arr) {

        int n = arr.length;
        int low = 0;
        int high = n - 1;
        if (n == 1) {
            return arr[0];
        }
        if (n == 2) {
            return Math.min(arr[0], arr[1]);
        }
        int min = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid - 1 >= 0 && mid + 1 <= high) {
                if (arr[mid - 1] > arr[mid] && arr[mid] < arr[mid + 1]) {
                    return arr[mid];
                }
            } else if (mid - 1 < 0 && mid + 1 >= 0) {
                if (arr[n - 1] > arr[mid] && arr[mid] < arr[mid + 1]) {
                    return arr[mid];
                }
            } else if (mid - 1 >= 0 && mid + 1 <= n) {
                if (arr[mid - 1] > arr[mid] && arr[mid] < arr[0]) {
                    return arr[mid];
                }
            }

            if (arr[low] < arr[mid]) {
                min = Math.min(arr[low], min);
                low = mid;
            } else {
                min = Math.min(arr[high], min);
                high = mid - 1;
            }

        }

        return min;

    }

    public static void main(String[] args) {
        int[] arr = { 3, 5, 0, 1, 2 };
        Min min = new Min();
        int minVal = min.findMin(arr);
        System.out.println(minVal);
    }
}