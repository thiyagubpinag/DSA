package array;

import java.util.Arrays;
import java.util.List;

public class ExamSeason {
    static int solve(List<Integer> start, List<Integer> end, int n) {
        int[][] times = new int[start.size()][2];
        for (int i = 0; i < start.size(); i++) {
            times[i][0] = start.get(i);
            times[i][1] = end.get(i);
        }
        Arrays.sort(times, (a1, a2) -> Integer.compare(a1[1], a2[1]));

        // Initialize variables
        int currentEndTime = 0;
        int maxFriends = 0;

        // Iterate through sorted times
        for (int[] time : times) {
            int startTime = time[0];

            // Check if current time allows scheduling this friend
            if (startTime >= currentEndTime) {
                currentEndTime = time[1]; // Update current end time
                maxFriends++; // Increase max friends
            }
        }

        return maxFriends;
    }

    public static void main(String[] args) {
        System.out.println(solve(List.of(1 ,2 ,3 ,6),List.of(3, 5, 9, 8),4));
    }
}
