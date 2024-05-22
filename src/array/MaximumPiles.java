package array;

public class MaximumPiles {
    public static void main(String[] args) {
        int[] arr = {1, 5,11};
        int res = maximumPiles(arr);

        System.out.println(res);
    }

    private static int maximumPiles(int[] arr) {

        int n = arr.length;
        if (n == 1) {
            System.out.println(arr[0]);
        }
        if (n == 2) {
            System.out.println(Math.abs(arr[0] - arr[1]));
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
        }
        int low = 1;
        int high = max;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int prev = findDistance(mid - 1, arr);
            int center = findDistance(mid, arr);
            int next = findDistance(mid + 1, arr);
            if (prev >= center && center <= next) {
                System.out.println(mid);
                return center;
            } else if (prev > center) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    private static int findDistance(int value, int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result += (Math.abs(arr[i] - value));
        }
        return result;
    }
}
