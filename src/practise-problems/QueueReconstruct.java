package test;

import java.util.Arrays;

public class QueueReconstruct {
    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};

        Arrays.sort(people, (i, j) -> {
            if (i[1] == j[1]) {
                return i[0] - j[0];
            } else {
                return i[1] - j[1];
            }
        });

        System.out.println("Done");
    }
}
