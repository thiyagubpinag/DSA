package array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer>[] dp = new List[rowIndex + 1];
        getRowContent(rowIndex, dp);
        return dp[rowIndex];
    }

    private static void getRowContent(int rowIndex, List<Integer>[] dp) {
        if (rowIndex < 0) {
            return;
        }
        if (rowIndex == 0) {
            dp[rowIndex] = List.of(1);
            return;
        }
        int noOfRecords = rowIndex + 1;
        getRowContent(rowIndex - 1, dp);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < noOfRecords; i++) {
            if (i == 0 || i == noOfRecords - 1) {
                result.add(1);
            } else {
                result.add(dp[rowIndex - 1].get(i) + dp[rowIndex - 1].get(i - 1));
            }
        }
        dp[rowIndex] = result;
    }

    public static void main(String[] args) {
        List<Integer> result = getRow(5);
        System.out.println(result);
    }

}
