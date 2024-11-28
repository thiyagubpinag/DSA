package test.microsoft;

public class Test1 {
    public static void main(String[] args) {
        int[] arr = {5, 10, 4, 0, 2, 4, 6, 31, 6, 6, 8, 5, 1, 2, 3};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        int leftSum = arr[0];
        int rightSum = sum - arr[0] - arr[1];
        for (int i = 1; i < arr.length - 2; i++) {
            if (leftSum == rightSum) {
                System.out.println(arr[i]);
            }
            leftSum += arr[i];
            rightSum -= arr[i + 1];
        }

    }
}
