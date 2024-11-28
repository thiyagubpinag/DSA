import java.util.List;

public class MinSubArray {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int min = Integer.MAX_VALUE;

        int currenMin = 0;
        int n = nums.size();
        int currentLenght = 0;
        for (int i = 0; i < n; i++) {
            currentLenght += 1;
            currenMin += nums.get(i);
            if (currentLenght >= l && currentLenght <= r) {
                min = Math.min(min, currenMin);
            }

            if (currenMin >= min) {
                currentLenght = 0;
                currenMin = 0;
            }
        }

        return min;

    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
        MinSubArray min = new MinSubArray();

        int res = min.minimumSumSubarray(arr, 2, 4);
        System.out.println(res);

    }
}
