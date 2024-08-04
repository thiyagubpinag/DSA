package string;

public class Test3 {
    public static int numberOfSubstrings(String s) {
        int n = s.length();
        int result = 0;

        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (s.charAt(i) == '1' ? 1 : 0);
            prefix[i] = sum;
        }
        sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += (s.charAt(i) == '1' ? 1 : 0);
            suffix[i] = sum;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= n - i; j++) {
                int sumOfZero = 0;
                int sumOfOne = 0;
                int left = j;
                int right = i + j - 1;
                if (left - right == 0) {
                    if (s.charAt(left) == '1') {
                        sumOfOne += 1;
                    } else {
                        sumOfZero += 1;
                    }
                } else {
                    if (left == 0 && right == n - 1) {
                        sumOfOne = prefix[n - 1];
                    } else if (left == 0) {
                        sumOfOne = sum - suffix[right + 1];
                    } else if (right == n - 1) {
                        sumOfOne = sum - prefix[left - 1];
                    } else {
                        sumOfOne = sum - (prefix[left - 1] + suffix[right + 1]);
                    }
                    sumOfZero = i - sumOfOne;
                }
                if (sumOfOne >= sumOfZero * sumOfZero) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String a = "101101";
        int res=numberOfSubstrings(a);
        System.out.println(res);
    }
}
