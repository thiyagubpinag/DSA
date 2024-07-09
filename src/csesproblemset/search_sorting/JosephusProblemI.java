package csesproblemset.search_sorting;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class JosephusProblemI {
    static void solve(long N, int k) {
        Queue<Long> q = new LinkedList<>();

        // Push all the children to the queue
        for (long i = 1; i <= N; i++)
            q.add(i);

        // Set the flag to false, so that the first child does
        // not get removed
        boolean flag = false;

        while (!q.isEmpty()) {
            // If we have to remove the element, print it
            if (flag) {
                long ele = q.poll();
                System.out.print(ele + " ");
            }
            // If we don't have to remove the element, push it
            // back to the queue
            else {
                for (int i = 0; i < k; i++)
                    if (!q.isEmpty())
                        q.add(q.poll());
            }
            // Toggle the value of flag so that only the
            // alternate elements get removed
            flag = !flag;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        solve(n, k);
    }
}
