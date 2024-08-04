package array;

import java.util.Arrays;

public class MinFlip {
    public static int minFlips(int[][] grid) {
        int[] res = new int[2];
        Arrays.fill(res, 0);
        for (int i = 0; i < grid.length; i++) {
            getPalindrome(grid[i], res, 0);
        }
        int rowLen = grid[0].length;
        int colLength = grid.length;
        int[] temp = new int[grid.length];
        for (int i = 0; i < rowLen; i++) {
            int start = 0;
            int end = colLength;
            while (start < end) {
                temp[start] = grid[start][i];
                start++;
            }
            getPalindrome(temp, res, 1);
        }
        return Math.min(res[0], res[1]);
    }

    public static void getPalindrome(int[] grid, int[] res, int index) {
        int result = 0;
        int left = 0;
        int right = grid.length - 1;
        while (left < right) {
            if (grid[left] != grid[right]) {
                result++;
            }
            left++;
            right--;
        }
        res[index] += result;

    }

    public static void main(String[] args) {
        int[][] grid = {{0, 0}};
        int res = minFlips(grid);
        System.out.println(res);
    }
}
