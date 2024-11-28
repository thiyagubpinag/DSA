package array;

import java.util.*;

public class MaxProfitJobScheduling {
    public static void main(String[] args) {
        int[] startTime = {1, 2, 3, 4, 6};
        int[] endTime = {3, 5, 10, 6, 9};
        int[] profit = {20, 20, 100, 70, 60};

        jobScheduling(startTime, endTime, profit);
    }

    static class JobScheduling {
        int startTime;
        int endTime;
        int profit;

        public JobScheduling(int startTime, int endTime, int profit) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }

        public int getEndTime() {
            return endTime;
        }
    }

    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        List<JobScheduling> jobSchedulingList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            jobSchedulingList.add(new JobScheduling(startTime[i], endTime[i], profit[i]));
        }

        jobSchedulingList.sort(Comparator.comparingInt(JobScheduling::getEndTime));
        List<int[]> sortedList = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            JobScheduling jobScheduling = jobSchedulingList.get(i);
            max = binarySearchLowerBound(jobScheduling, sortedList, max, set);
        }

        return max;

    }

    private static int binarySearchLowerBound(JobScheduling jobScheduling, List<int[]> sortedList, int max,HashSet<Integer> set) {
        int startTime = jobScheduling.startTime;
        int low = 0;
        int high = sortedList.size()-1;
        int n = sortedList.size();
        int[] output=new int[2];
        if (n == 0) {
            output[0] = jobScheduling.endTime;
            output[1] = jobScheduling.profit;
            sortedList.add(output);
            set.add(output[0]);
        } else {
            while (low <= high) {
                int mid = low + (high - low) / 2;
                int[] sortedTemp = sortedList.get(mid);
                if (sortedTemp[0] > startTime) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            output[0] = jobScheduling.endTime;
            if (high == -1) {
                output[1] = jobScheduling.profit;
            }else if(low==sortedList.size()){
                output[1] = jobScheduling.profit+sortedList.get(sortedList.size()-1)[1];
            }else{
                output[1] = jobScheduling.profit+sortedList.get(low-1)[1];
            }
            int listSize = sortedList.size();
            if(sortedList.get(listSize-1)[0]==jobScheduling.endTime){
                sortedList.set(listSize-1,output);
            }else{
                sortedList.add(output);
            }
        }


        return Math.max(max,output[1]);
    }

}
