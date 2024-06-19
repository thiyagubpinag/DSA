package array;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Vector;
import java.util.Arrays;


public class SweeperProblem {

    public static int minCleaningTime(int[] roadLengths, int numSweepers) {
        if (roadLengths.length == 0 || numSweepers == 0) {
            return 0; // No roads or no sweepers, no cleaning time
        }

        // Sort the road lengths in ascending order
        Arrays.sort(roadLengths);

        // Initialize variables
        int currentMax = 0; // Maximum workload for any sweeper
        int sweepersUsed = 1; // Number of sweepers currently used

        for (int roadLength : roadLengths) {
            // Check if adding this road exceeds current sweeper's workload
            if (currentMax + roadLength > currentMax) {
                currentMax = roadLength; // Start a new workload for another sweeper
                sweepersUsed++;
            } else {
                currentMax += roadLength; // Add to current sweeper's workload
            }
        }

        // Minimum cleaning time is the maximum workload for any sweeper
        return currentMax;
    }

    public static void main(String[] args) {
        int[] roadLengths = {5, 10, 30, 20, 15};
        int numSweepers = 2;

        int minTime = minCleaningTime(roadLengths, numSweepers);
        System.out.println("Minimum cleaning time: " + minTime);

        int[] roadLengthsNew = {5, 10, 30, 20, 15};
        Vector<Integer> arr = new Vector<>();
        for (int i = 0; i < roadLengthsNew.length; i++) {
            arr.add(roadLengthsNew[i]);
        }
        long res = minTime(arr, arr.size(), numSweepers);
        System.out.println(res);

        res=minimumTimeToCleanRoads(arr.size(),arr,numSweepers);
        System.out.println(res);


        PriorityQueue<Integer> pqu=new PriorityQueue<>();
        pqu.peek();
    }

    static long minTime(Vector<Integer> arr, int n, int k) {
        long currentMax = 0;
        long max = Long.MIN_VALUE;
        long sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
        }
        if (sum == 0) {
            return sum;
        }
        long dividend = sum / k;
        for (int i = 0; i < arr.size(); i++) {
            currentMax += arr.get(i);
            if (currentMax >= dividend && k != 0) {
                if (arr.get(i) > dividend) {
                    k--;
                    currentMax = Math.max(arr.get(i), currentMax - arr.get(i));
                }
                max = Math.max(max, currentMax);
                k--;
                currentMax = 0;
            }
        }
        max = Math.max(max, currentMax);
        return max;

    }

    public static int minimumTimeToCleanRoads(int N, Vector<Integer> roads, int K) {
        Collections.sort(roads);
        int low = 0;
        int high=roads.stream().reduce(0, Integer::sum);

        while (low < high) {
            int mid = (low + high) / 2;

            if (canCleanRoads(roads, K, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static boolean canCleanRoads(Vector<Integer> roads, int sweepers, int maxTime) {
        int numSweepers = 1;
        int totalTime = 0;

        for (int road : roads) {
            if (totalTime + road <= maxTime) {
                totalTime += road;
            } else {
                numSweepers++;
                totalTime = road;
            }
        }

        return numSweepers <= sweepers;
    }


}
