package array;

public class MaxNoOfPiles {
    public static void main(String[] args) {
        int[] a = {1, 5,5,10};

        int low = 0;
        int high = a.length-1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int direction = possibleCase(a, mid);
            if (direction == 0) {
                int diff=0;
                for(int i=0;i<a.length;i++){
                    diff+=Math.abs(a[i]-a[mid]);
                }
                System.out.println(diff);
                break;
            }
            if (direction == 1) {
                high = mid;
            } else {
                low = mid;
            }
        }

    }

    private static int possibleCase(int[] a, int mid) {
        int prev = mid - 1;
        int next = mid + 1;
        if (a[mid] > a[prev] && a[mid] < a[next]) {
            return 0;
        }
        if (a[mid] < a[prev] && a[mid] > a[next]) {
            return -1;
        } else {
            return 1;
        }
    }

}
