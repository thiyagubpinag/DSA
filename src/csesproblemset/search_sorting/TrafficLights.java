package csesproblemset.search_sorting;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TrafficLights {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arrStr1 = sc.nextLine().split(" ");
        String[] arrStr2 = sc.nextLine().split(" ");
        int x = Integer.parseInt(arrStr1[0]);
        int n = Integer.parseInt(arrStr1[1]);
        int[] p = new int[n];
        for (int i = 0; i < n; i++)
            p[i] = Integer.parseInt(arrStr2[i]);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        pq.add(0);
        pq.add(x);
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            pq.add(p[i]);
            PriorityQueue<Integer> temp = new PriorityQueue<>(pq);
            int prev = temp.poll();
            int max = Integer.MIN_VALUE;
            while (!temp.isEmpty()) {
                int val = temp.poll();
                max = Math.max(max, prev - val);
                prev = val;
            }

            result[i] = max;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }

    }
}
