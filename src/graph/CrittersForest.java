package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class CrittersForest {

    public static int solve(int n, List<String> s) {
        int max = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                if (s.get(i).charAt(j) == '*') {
                    max = applyDfs(i, j, n, s, max);
                }
            }
        }
        return max;
    }

    static int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private static int applyDfs(int start, int end, int n, List<String> s, int max) {
        StringBuilder builder = new StringBuilder(s.get(start));
        int count = 1;
        if (builder.charAt(end) == '*') {
            for (int[] ints : direction) {
                int startX = start + ints[0];
                int endY = end + ints[1];
                if (validPath(startX, endY, n)) {
                    StringBuilder temp = new StringBuilder(s.get(startX));
                    if (temp.charAt(endY) == '*') {
                        count++;
                    }
                }
            }
        }
        return Math.max(max, count);
    }

    private static boolean validPath(int start, int end, int n) {
        return start >= 0 && start < 2 && end >= 0 && end < n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<String> arrList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            String s = sc.nextLine();
            arrList.add(s);
        }
        int res = solve(n, arrList);
        System.out.println(res);
    }
}
