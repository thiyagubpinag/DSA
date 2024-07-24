package csesproblemset.search_sorting.magths;

import java.util.Arrays;
import java.util.Scanner;

public class Josephus {
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        String[] arrStr = sc.nextLine().split(" ");
        int n = Integer.parseInt(arrStr[0]);
        int[][] input = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] arrStr1 = sc.nextLine().split(" ");
            input[i][0] = Integer.parseInt(arrStr1[0]);
            input[i][1] = Integer.parseInt(arrStr1[1]);
        }

        int[] output = getOutput(input, n);
        for (int i = 0; i < n; i++) {
            System.out.println(output[i]);
        }*/

        lengthOfLIS(new int[]{1, 7, 5});
    }

    private static int[] getOutput(int[][] input, int n) {
       return new int[0];
    }
    public static int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int arr[]=Arrays.copyOf(nums,n);
        Arrays.sort(arr);
        return -1;
    }
}
