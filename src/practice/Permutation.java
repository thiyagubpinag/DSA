package practice;

import java.util.Collections;

public class Permutation {
    public static void nextPermutation(int[] nums) {
        int index = -1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] > nums[j - 1]) {
                index = j;
            }
        }

        if (index != -1) {
            if (nums[index - 1] < nums[nums.length - 1] && nums[index] > nums[nums.length - 1]) {
                swap(nums, index - 1, nums.length - 1);
                swap(nums, index, nums.length - 1);
            } else if (nums[index - 1] > nums[nums.length - 1] && nums[index] > nums[nums.length - 1]) {
                swap(nums, index, index - 1);
                swap(nums, index, nums.length - 1);
            } else {
                swap(nums, index, index - 1);
            }
        } else {
            swap(nums, 0, nums.length - 1);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 1};
        nextPermutation(a);
        System.out.println("Done");
    }
}
