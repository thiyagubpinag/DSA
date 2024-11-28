import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> resultList = new ArrayList<>();

        int i = 0;
        int n = intervals.length;
        int start = newInterval[0];
        int end = newInterval[1];
        while (i < n) {
            if (intervals[i][0] <= start && intervals[i][1] >= start) {
                int j = i + 1;
                while (j < n) {
                    if (intervals[j][0] > end) {
                        intervals[i][1] = end;
                        break;
                    }
                    intervals[i][1] = intervals[j][1];
                    j++;
                }
                resultList.add(intervals[i]);
                i = j;
            } else {
                resultList.add(intervals[i]);
                i++;
            }
        }

        int[][] result = new int[resultList.size()][2];
        for (int k = 0; k < resultList.size(); k++) {
            result[k] = resultList.get(k);
        }

        return result;

    }

    public static void main(String[] args) {
        int[][] intervals = { { 1, 2 }, { 2, 4 } };
        int[] newInterval = { 2, 5 };
        InsertInterval insertInterval = new InsertInterval();
        int[][] res = insertInterval.insert(intervals, newInterval);
        for (int[] arr : res) {
            System.out.println("[" + arr[0] + ", " + arr[1] + "]");
        }
    }
}
