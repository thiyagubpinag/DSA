package array;

public class minimumDifferenceQuestion {
    public int minimumDifference(int[] nums) {
        return minimumDifference(nums, nums.length);
    }


    public int minimumDifference(int[] arr, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0) sum += arr[i];
        }
        boolean subset[][] = new boolean[sum + 1][n + 1];

        // If sum is 0, then answer is true
        for (int i = 0; i <= n; i++)
            subset[0][i] = true;

        // If sum is not 0 and set is empty,
        // then answer is false
        for (int i = 1; i <= sum; i++)
            subset[i][0] = false;

        // Fill the subset table in bottom
        // up manner
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                subset[i][j] = subset[i][j - 1];
                if (i >= arr[j - 1]) subset[i][j] = subset[i][j] || subset[i - arr[j - 1]][j - 1];
            }
        }

        int mid = sum / 2;
        int left = mid;
        for (int i = mid; i >= 0; i--) {
            if (subset[i][n]) {
                left = i;
                break;
            }
            left = i;
        }
        int right = sum - left;
        return right - left;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4};
        minimumDifferenceQuestion minimumDifferenceQuestion = new minimumDifferenceQuestion();
        int res = minimumDifferenceQuestion.minimumDifference(arr);
        System.out.println(res);
    }
}
