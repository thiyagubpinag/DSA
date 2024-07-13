package dp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ActivitySelection {
    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int solve(List<Integer> start, List<Integer> end, int n) {
        //Write your code here
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        List<Pair> pairList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pairList.add(new Pair(start.get(i), end.get(i)));
            min = Math.min(min, start.get(i));
            max = Math.max(max, end.get(i));
        }
        pairList.sort(Comparator.comparing(i -> i.x));

        int startNo = 0;
        int endNo = 1;
        int count = 1;
        while (endNo < n) {
            if (pairList.get(startNo).y <= pairList.get(endNo).x) {
                count++;
                startNo = endNo;
            } else if (pairList.get(endNo).x <= pairList.get(startNo).y && pairList.get(endNo).y <= pairList.get(startNo).y) {
                startNo = endNo;
            }
            endNo++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] arrStr = sc.nextLine().split(" ");
        String[] arrStr1 = sc.nextLine().split(" ");
        List<Integer> arr = new ArrayList<>();
        List<Integer> arr1 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(arrStr[i]));
            arr1.add(Integer.parseInt(arrStr1[i]));
        }
        int res = solve(arr, arr1, n);
        System.out.println(res);
    }
}
