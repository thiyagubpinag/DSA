package array;

import java.util.*;

public class MinMovesToSeat {
    public static int minMovesToSeat(int[] seats, int[] students) {

        TreeSet<Integer> sortedSet = new TreeSet();
        HashMap<Integer, Integer> tempMap = new HashMap<>();
        for (int i = 0; i < seats.length; i++) {
            sortedSet.add(seats[i]);
            tempMap.put(seats[i], tempMap.getOrDefault(seats[i], 0) + 1);
        }
        int sum = 0;
        int moves;
        Integer previousValue = null;
        int leftValue, rightValue, minValue;
        boolean flag = false;
        for (int i = 0; i < students.length; i++) {
            moves = 0;
            previousValue=null;
            if (sortedSet.contains(students[i])) {
                sum += moves;
                removeInSet(sortedSet,tempMap,students[i]);
                continue;
            }
            flag = false;
            for (Integer value : sortedSet) {
                if (value > students[i]) {
                    rightValue = value - students[i];
                    if (previousValue != null) {
                        leftValue = students[i] - previousValue;
                        minValue = Math.min(leftValue, rightValue);
                        if (minValue == leftValue) {
                            removeInSet(sortedSet,tempMap,previousValue);
                            sum += leftValue;
                        } else {
                            sum += rightValue;
                            removeInSet(sortedSet,tempMap,value);
                        }
                        flag = true;
                        break;
                    } else {
                        sum += rightValue;
                        removeInSet(sortedSet,tempMap,value);
                        flag = true;
                        break;
                    }
                }
                previousValue = value;
            }
            if (!flag) {
                sum += students[i] - previousValue;
                removeInSet(sortedSet,tempMap,previousValue);
            }
        }

        return sum;
    }

    private static void removeInSet(TreeSet<Integer> sortedSet, HashMap<Integer, Integer> tempMap, Integer value) {
        if (tempMap.get(value) == 1) {
            sortedSet.remove(value);
        }
        tempMap.put(value,tempMap.get(value)-1);
    }

    public static void main(String[] args) {
        int[] seats = {2, 2, 6, 6};
        int[] students = {1, 3, 2, 6};
        int result = minMovesToSeat(seats, students);
        System.out.println(result);
    }
}
