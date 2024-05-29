package dp;

public class CoinsProblem {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5};
        int n = 3;
        int sum = 5;

        int res = knapsack(arr, n-1, sum);
        System.out.println(res);

    }

    private static int knapsack(int[] arr, int n, int sum) {
        if (n < 0 || sum < 0) {
            return 0;
        }
        if(sum==0){
            return 1;
        }
        int ans;
        int include = knapsack(arr, n, sum - arr[n]);
        int exclude = knapsack(arr, n - 1, sum);
        ans = include + exclude;
        return ans;
    }
}
