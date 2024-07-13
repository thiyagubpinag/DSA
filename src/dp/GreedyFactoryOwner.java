package dp;

import java.util.Arrays;
import java.util.Scanner;

public class GreedyFactoryOwner {
    public static int solve(int n, int[] ar) {
        //Write your code here

        int sum = 0;
        int[] result = new int[n];
        int minIndex = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (ar[i] < min) {
                min = ar[i];
                minIndex = i;
            }
        }
        result[minIndex] = 1000;
        sum += result[minIndex];
        for (int i = minIndex - 1; i >= 0; i--) {
            if (ar[i] < ar[i + 1]) {
                result[i] = result[i + 1] - 1000;
            } else if (ar[i] > ar[i + 1]) {
                result[i] = result[i + 1] + 1000;
            } else {
                result[i] = result[i + 1];
            }
            sum += result[i];
        }

        for (int i = minIndex + 1; i < n; i++) {
            if (ar[i] < ar[i - 1]) {
                result[i] = result[i - 1] - 1000;
            } else if (ar[i] > ar[i - 1]) {
                result[i] = result[i - 1] + 1000;
            } else {
                result[i] = result[i - 1];
            }
            sum += result[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] arrStr = sc.nextLine().split(" ");
        int[] arr = new int[arrStr.length];
        for (int i = 0; i < arrStr.length; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }
        int sum = solve(n, arr);
        System.out.println(sum);
    }
}
