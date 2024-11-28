import java.util.TreeSet;

public class MinWasteSpace {
    public int minWastedSpace(int[] packages, int[][] boxes) {

        int sum = 0;
        int n = packages.length;
        int min = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < boxes.length; i++) {
            TreeSet<Integer> set = new TreeSet<>();
            for (int j = 0; j < boxes[i].length; j++) {
                set.add(boxes[i][j]);
            }
            sum = 0;
            boolean flag = false;
            for (int k = 0; k < n; k++) {
                Integer leastElemetric = set.ceiling(packages[k]);
                if (leastElemetric != null) {
                    int waste = Math.abs(packages[k] - leastElemetric);
                    sum += waste;
                } else {
                    count++;
                    flag = true;
                    break;
                }
            }
            if (!flag)
                min = Math.min(min, sum);
        }
        if (count == boxes.length) {
            return -1;
        }
        return min;

    }

    public static void main(String[] args) {
        int[] packages = { 3, 5, 8, 10, 11, 12 };
        int[][] boxes = { { 12 }, { 11, 9 }, { 10, 5, 14 } };
        MinWasteSpace minWasteSpace = new MinWasteSpace();
        int wastedSpace = minWasteSpace.minWastedSpace(packages, boxes);
        System.out.println(wastedSpace);
    }
}
