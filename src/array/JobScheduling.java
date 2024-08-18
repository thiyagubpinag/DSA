package array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class JobScheduling {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(0, 0);
        Arrays.sort(jobs, Comparator.comparingInt(job -> job[1]));
        for (int i = 0; i < jobs.length; i++) {
            int temp = treeMap.floorKey(jobs[i][0]);
            if (treeMap.get(temp) + jobs[i][2] > treeMap.lastEntry().getValue()) {
                treeMap.put(jobs[i][1], treeMap.get(temp) + jobs[i][2]);
            }
        }

        return treeMap.lastEntry().getValue();
    }

    public static void main(String[] args) {
        int[] startTime = {1, 2, 3, 3};
        int[] endTime = {3, 4, 5, 6};
        int[] profit = {50, 10, 40, 70};
        JobScheduling jobScheduling = new JobScheduling();
        jobScheduling.jobScheduling(startTime, endTime, profit);
    }
}
