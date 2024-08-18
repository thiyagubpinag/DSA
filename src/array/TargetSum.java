package array;

public class TargetSum {
    public long minimumOperations(int[] nums, int[] target) {
        int n = nums.length;
        long[] diff = new long[n];

        for (int i = 0; i < n; i++) {
            diff[i] = target[i] - nums[i];
        }

        long iOp = 0;
        long dOp = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (diff[i] > 0) {
                if (iOp < diff[i]) ans += (diff[i] - iOp);
                iOp = diff[i];
                dOp = 0;
            } else if (diff[i] < 0) {
                if (dOp < -diff[i]) ans += (-diff[i] - dOp);
                dOp = -diff[i];
                iOp = 0;
            } else {
                iOp = 0;
                dOp = 0;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        TargetSum targetSum = new TargetSum();
        targetSum.minimumOperations(new int[]{1, 3, 2}, new int[]{2, 1, 4});
    }
}
