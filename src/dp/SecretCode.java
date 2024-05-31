package dp;

public class SecretCode {
    static int count = 0;

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        //int res = countSecretCode(arr.length, arr);
        //System.out.println(res);
        int res1 = countSecretCodeDP(arr.length, arr);
        System.out.println(res1);
    }

    private static int countSecretCodeDP(int n, int[] arr) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        String input = "";
        for (int value : arr) {
            input += value;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                String temp = input.substring(j, i);
                if (Integer.parseInt(temp) <= 26) {
                    dp[i] += dp[j];
                }
            }
        }
        return dp[n];


    }

    private static int countSecretCode(int n, int[] arr) {
        countSecretCode(arr, n - 1);
        return count;
    }

    private static void countSecretCode(int[] arr, int n) {
        if (n < 0) {
            return;
        }

        if (n == 0) {
            count++;
            return;
        }
        countSecretCode(arr, n - 1);
        if (n - 1 >= 0) {
            int total = Integer.parseInt(String.valueOf(arr[n - 1]) + String.valueOf(arr[n]));
            if (total <= 26) {
                if (n - 1 == 0) {
                    count++;
                } else {
                    countSecretCode(arr, n - 2);
                }
            }
        }


    }
}
