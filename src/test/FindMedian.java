package test;

import java.util.*;

public class FindMedian {
    public static List<Integer> findMedian(List<Integer> arr, int n) {

        PriorityQueue<Integer> p = new PriorityQueue<>();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int i = 0;
        List<Integer> result = new ArrayList<>();
        while (i < n) {
            p.add(arr.get(i));
            q.clear();
            q.addAll(p);
            boolean flag = true;
            while (flag) {
                int k = (i + 1) % 2 == 0 ? (i + 1) / 2 - 1 : (i + 1) / 2;
                while (k-- > 0) {
                    q.poll();
                }
                int mid = (i + 1) % 2 == 0 ? 2 : 1;
                int sum = 0;
                int temp = mid;
                while (temp-- > 0) {
                    sum += q.poll();
                }
                result.add(sum / mid);
                System.out.print(Double.valueOf(sum/mid)+" ");
                flag = false;
            }
            i++;
        }
        return result;

    }

    public static void main(String[] args) {
        int[] arr = {5 ,15, 1, 3};
        List<Integer> result = new ArrayList();
        for (int i = 0; i < arr.length; i++)
            result.add(arr[i]);
        List<Integer> output = findMedian(result, arr.length);
        System.out.println(output);
        PriorityQueue p=new PriorityQueue(Collections.reverseOrder());


    }
    int[] get(){
        return new int[]{-1, -1, -1, 6, 5, 4};
    }
}

//12  15  12  15  17  15  13  15  13  15  17  15  17  15  13
//12, 15, 12, 14, 14, 14, 13, 13, 13, 13, 14, 13, 14, 14, 13
