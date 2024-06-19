package tree;

import java.util.Arrays;

public class Heapify {

    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 6, 7,0,10};
        int n = arr.length;
        for (int i = (n - 1) / 2; i >= 0; i--) {
            heapify(arr, i);
        }

        Arrays.stream(arr).forEach(System.out::println);

    }

    private static void heapify(int[] arr, int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int smallest = index;
        if (left < arr.length && arr[smallest] > arr[left]) {
            smallest = left;
        }
        if (right < arr.length && arr[smallest] > arr[right]) {
            smallest = right;
        }
        if (smallest != index) {
            int temp=arr[index];
            arr[index]=arr[smallest];
            arr[smallest]=temp;
            heapify(arr, smallest);
        }
    }
}
