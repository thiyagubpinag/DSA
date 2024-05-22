package array;

import java.util.*;

public class FindLeastGreater {
    public static List<Integer> findLeastGreater(int n, int[] arr) {
        //Write your code here
        if (n < 0) {
            return null;
        }
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> result = new ArrayList();
        Stack<Integer> stack = new Stack<>();
        result.add(0, -1);
        stack.add(arr[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            if (stack.peek() < arr[i]) {
                while (!stack.isEmpty()) {
                    if (stack.peek() < arr[i]) {
                        stack.pop();
                    } else {
                        break;
                    }
                }
                result.add(0, stack.isEmpty() ? -1 : stack.peek());
                stack.add(arr[i]);
            } else {
                result.add(0, stack.peek());
                stack.add(arr[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 6, 9, 1, 3, 2};
        List<Integer> templIST = findAtLeastGreater(arr.length, arr);
        templIST.forEach(i -> System.out.print(i + " "));
        int diff=minAbsoluteDifference(Arrays.asList(5 ,3 ,2 ,10, 15),1);
        System.out.println(diff);
    }

    private static List<Integer> findAtLeastGreater(int N, int[] arr) {
        List<Integer> resultList = new ArrayList<>();
        TreeSet<Integer> s = new TreeSet<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            s.add(arr[i]);
            Integer it = s.higher(arr[i]);
            if (it == null) resultList.add(0, -1);
            else resultList.add(0, it);
        }
        return resultList;
    }

    public static int minAbsoluteDifference(List<Integer> nums, int x) {
        Collections.sort(nums);
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.size()-x;i++){
            int start=i;
            int end=i+x;
            min=Math.min(min,nums.get(end)-nums.get(start));
        }
        return min;

    }
}
