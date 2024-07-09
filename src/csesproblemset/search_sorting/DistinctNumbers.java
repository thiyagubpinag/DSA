package csesproblemset.search_sorting;

import java.util.HashSet;
import java.util.Scanner;

public class DistinctNumbers {
    public static int getDistinctNumber(int n, int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
        }
        return set.size();
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
        int res = getDistinctNumber(n, arr);
        System.out.println(res);
    }
}
