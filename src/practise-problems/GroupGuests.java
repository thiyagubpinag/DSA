package test;
public class GroupGuests {

    public static int minSwaps(int[] nums) {
        int n = nums.length;
        int[] group1 = new int[n];
        int[] group2 = new int[n];
        int[] group3 = new int[n];

        int group1Count = 0, group2Count = 0, group3Count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                group1[group1Count++] = nums[i];
            } else if (nums[i] == 2) {
                group2[group2Count++] = nums[i];
            } else {
                group3[group3Count++] = nums[i];
            }
        }

        int idealCount = n / 3;
        int swaps = 0;

        int imbalance1 = group1Count - idealCount;
        int imbalance2 = group2Count - idealCount;
        int imbalance3 = group3Count - idealCount;

        // Swap guests to achieve balanced distribution
        for (int i = 0; i < group1Count; i++) {
            if (imbalance1 > 0) {
                if (imbalance2 < 0) {
                    swap(group1, i, group2, Math.abs(imbalance2));
                    imbalance1--;
                    imbalance2++;
                    swaps++;
                } else if (imbalance3 < 0) {
                    swap(group1, i, group3, Math.abs(imbalance3));
                    imbalance1--;
                    imbalance3++;
                    swaps++;
                }
            } else {
                break;
            }
        }

        for (int i = 0; i < group2Count; i++) {
            if (imbalance2 > 0) {
                if (imbalance1 < 0) {
                    swap(group2, i, group1, Math.abs(imbalance1));
                    imbalance2--;
                    imbalance1++;
                    swaps++;
                } else if (imbalance3 < 0) {
                    swap(group2, i, group3, Math.abs(imbalance3));
                    imbalance2--;
                    imbalance3++;
                    swaps++;
                }
            } else {
                break;
            }
        }

        for (int i = 0; i < group3Count; i++) {
            if (imbalance3 > 0) {
                if (imbalance1 < 0) {
                    swap(group3, i, group1, Math.abs(imbalance1));
                    imbalance3--;
                    imbalance1++;
                    swaps++;
                } else if (imbalance2 < 0) {
                    swap(group3, i, group2, Math.abs(imbalance2));
                    imbalance3--;
                    imbalance2++;
                    swaps++;
                }
            } else {
                break;
            }
        }

        return swaps;
    }

    private static void swap(int[] arr1, int index1, int[] arr2, int index2) {
        int temp = arr1[index1];
        arr1[index1] = arr2[index2];
        arr2[index2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 2, 1};
        System.out.println("Minimum swaps required: " + minSwaps(nums)); // Output: 3
    }
}
