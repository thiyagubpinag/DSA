package array;

public class CountPoints {
    public static int[] countPoints(int[][] points, int[][] queries) {
        int[] countArr = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int count = 0;
            for (int j = 0; j < points.length; j++) {
                double dx=Math.pow(Math.abs(queries[i][0] - points[j][0]), 2);
                double dy=Math.pow(Math.abs(queries[i][1] - points[j][1]), 2);
                double radius=Math.pow(queries[i][2], 2);
                if (dx+dy<=radius) {
                    count++;
                }
            }
            countArr[i] = count;
        }
        return countArr;
    }

    public static void main(String[] args) {
        int[][] points = {{1, 3}, {3, 3}, {5, 3}, {2, 2}};
        int[][] queries =
                {{2, 3, 1}, {4, 3, 1}, {1, 1, 2}};
        int[] countPoints = countPoints(points, queries);
        for (int i = 0; i < countPoints.length; i++) {
            System.out.print(countPoints[i] + " ");
        }

    }
}
