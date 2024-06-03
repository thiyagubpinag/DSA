package test;

import java.util.*;
import java.util.Stack;

public class MinOperation {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 1, 3, 3};
        int swap = minimumOperations(arr);
        System.out.println(swap);

    }
    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static int minimumOperations(int[] arr) {
        int n = arr.length;

        // Create two arrays and
        // use as pairs where first
        // array is element and second array
        // is position of first element
        ArrayList<Pair> arrpos
                = new ArrayList<Pair>();
        for (int i = 0; i < n; i++)
            arrpos.add(
                    new Pair(arr[i], i));

        // Sort the array by array element values to
        // get right position of every element as the
        // elements of second array.
        arrpos.sort(
                new Comparator<Pair>() {
                    @Override
                    public int compare(
                            Pair o1,
                            Pair o2)
                    {
                        if (o1.first < o2.first)
                            return -1;

                            // We can change this to make
                            // it then look at the
                            // words alphabetical order
                        else if (o1.first == o2.first)
                            return 0;

                        else
                            return 1;
                    }
                });

        // To keep track of visited elements. Initialize
        // all elements as not visited or false.
        Boolean[] vis = new Boolean[n];
        Arrays.fill(vis, false);

        // Initialize result
        int ans = 0;

        // Traverse array elements
        for (int i = 0; i < n; i++) {
            // already swapped and corrected or
            // already present at correct pos
            if (vis[i] || arrpos.get(i).second == i)
                continue;

            // find out the number of  node in
            // this cycle and add in ans
            int cycle_size = 0;
            int j = i;
            while (!vis[j]) {
                vis[j] = true;

                // move to next node
                j = arrpos.get(j).second;
                cycle_size++;
            }

            // Update answer by adding current cycle.
            if (cycle_size > 0) {
                ans += (cycle_size - 1);
            }
        }

        // Return result
        return ans;

    }
}
