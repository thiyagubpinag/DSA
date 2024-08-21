package array;

import java.util.Arrays;

public class MaxEvents {
    public static int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[1] - b[1]);
        int count = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < events.length; i++) {
            max = Math.max(Arrays.stream(events[i]).max().getAsInt(), max);
        }
        boolean[] existArr = new boolean[max + 1];
        for (int i = 0; i < events.length; i++) {
            boolean flag = false;
            for (int j = events[i][0]; j <= events[i][1]; j++) {
                if (!existArr[j]) {
                    existArr[j] = true;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }

        int data= (int) Math.pow(10,5);
        return count;

    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {1, 2}, {3, 3}, {1, 5}, {1, 5}};
        int res = maxEvents(arr);
        System.out.println(res);
    }
}
