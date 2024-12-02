import java.util.*;

class MergeSortVariation {

    public int maxDiff(ArrayList<Integer> a, int n) {

        int[] RMax = new int[n];
        RMax[n - 1] = a.get(n - 1);

        // Create RMax[] such that it stores
        // the maximum element on its right
        for (int i = n - 2; i >= 0; i--) {
            RMax[i] = Math.max(RMax[i + 1], a.get(i));
        }

        // Initialize index of left and right elements
        int i = 0, j = 0;

        // Initialize difference between indexes
        int maxDiff = -1;

        // Traverse both arrays from left to right
        while (j < n && i < n) {
            if (a.get(i) <= RMax[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j++;
            } else {
                i++;
            }
        }

        return maxDiff;
    }

    public static void main(String[] args) {
        int[] numbers = { 34, 8, 10, 3, 2, 80, 30, 33, 1 };
        ArrayList<Integer> numberList = new ArrayList<>();
        for (int i : numbers) {
            numberList.add(i);
        }
        MergeSortVariation mergeSortVariation = new MergeSortVariation();
        int res = mergeSortVariation.maxDiff(numberList, numbers.length);
        System.out.println(res);

    }
}