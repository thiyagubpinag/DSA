package dp;

import java.util.*;

public class MaximumXOR {
    public static int maxXOR(int[] nums) {
        List<Integer> inputList = new ArrayList<>(Arrays.stream(nums).boxed().toList());
        inputList.sort(Collections.reverseOrder());
        int maxXor = 0;
        for (int i = 1; i < inputList.size(); i++) {
            maxXor = Math.max(maxXor, inputList.get(i) ^ inputList.get(i - 1));
        }
        return maxXor;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 4, 6};
        int[] nums2 = {1, 2, 3, 9, 2};
        System.out.println(maxXOR(nums1)); // Output: 7
        System.out.println(maxXOR(nums2)); // Output: 11
    }
}
