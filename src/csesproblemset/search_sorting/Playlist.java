package csesproblemset.search_sorting;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Playlist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] arrStr = sc.nextLine().split(" ");
        int[] arr = new int[arrStr.length];
        for (int i = 0; i < arrStr.length; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }

        int count = getPlayList(arr, n);
        System.out.println(count);
    }

    private static int getPlayList(int[] arr, int n) {
        //1 2 1 3 2 7 4 2
        int max = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        while (j < n) {
            if (map.containsKey(arr[j])) {
                while (i <= j) {
                    int value = map.get(arr[i]) - 1;
                    if (value <= 0) {
                        map.remove(arr[i]);
                    } else {
                        map.put(arr[i], value);
                    }
                    if (arr[i] == arr[j]) {
                        i++;
                        break;
                    }
                    i++;
                }
            }
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
            max = Math.max(j - i + 1, max);
            j++;
        }
        return max;

    }
}
