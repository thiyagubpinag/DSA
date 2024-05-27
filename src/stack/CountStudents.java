package stack;

import java.util.*;

public class CountStudents {
    public static int countStudents(List<Integer> students, List<Integer> sandwiches) {
        int queueSize = students.size();
        int stackSize = sandwiches.size();
        Queue<Integer> queue = new LinkedList<>();
        int[] temp = new int[2];
        boolean flag = false;
        students.forEach(i -> {
            queue.add(i);
            temp[i]++;
        });

        Stack<Integer> stack = new Stack<>();
        for (int i = stackSize - 1; i >= 0; i--) {
            stack.push(sandwiches.get(i));
        }


        while (!queue.isEmpty() && !stack.isEmpty()) {
            if (Objects.equals(queue.peek(), stack.peek())) {
                stack.pop();
                temp[queue.poll()]--;
            } else {
                int tempInt = queue.peek();
                queue.poll();
                queue.add(tempInt);
                int check = queue.peek() == 0 ? 1 : 0;
                if (temp[check] == 0) {
                    flag = true;
                    break;
                }
            }
        }

        return flag ? queue.size() : 0;

    }

    public static void main(String[] args) {
        List<Integer> students1 = List.of(1, 1, 1, 0, 0, 1);
        List<Integer> sandwiches1 = List.of(1, 0, 0, 0, 1, 1);
        System.out.println(countStudents(students1, sandwiches1)); // Output: 3

        List<Integer> students2 = List.of(1, 1, 0, 0);
        List<Integer> sandwiches2 = List.of(0, 1, 0, 1);
        System.out.println(countStudents(students2, sandwiches2)); // Output: 0
    }
}
